package NeuralNetworks;

import Layer.*;
import Utils.DatasetParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class NeuralNetwork implements INeuralNetwork {
    private DatasetParser DataParser;
    private ArrayList<ILayer> layers;
    private int nTries;
    private double MSE;
    private double globalAccuracy;
    ArrayList<ArrayList<Integer>> confusionMatrix;

    //jp dijo k lo hiciera como fuera mas facil j3j3
    //ultimo parametro no se usa pk se puede deducir
    //de la cantidad de neuronas de la ultima layer
    public NeuralNetwork(int numberOfLayers, ArrayList<Integer> numberOfNeuronsPerLayer, int numberOfInputs, int numberOfOutputs) {
        layers = new ArrayList<>();
        addLayers(numberOfLayers, numberOfNeuronsPerLayer, numberOfInputs);
        connectLayers();
        nTries = 0;
        MSE = 0;
        globalAccuracy = 0;
        createConfusionMatrix(numberOfOutputs);
        DataParser = new DatasetParser("data/bezdekIris.txt");
    }

    private void createConfusionMatrix(int numberOfOutputs) {
        confusionMatrix = new ArrayList<>();
        for (int i = 0; i < numberOfOutputs; i++) {
            confusionMatrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        }
    }

    @Override
    public void setData(String filePath) {
        DataParser = new DatasetParser(filePath);
    }

    private void connectLayers() {
        int size = layers.size();
        getFirstLayer().setNextLayer(layers.get(1));
        for (int i = 1; i < size - 1; i++) {
            layers.get(i).setPreviousLayer(layers.get(i - 1));
            layers.get(i).setNextLayer(layers.get(i + 1));
        }
        getLastLayer().setPreviousLayer(layers.get(size - 2));
    }

    private void addLayers(int numberOfLayers, ArrayList<Integer> numberOfNeuronsPerLayer, int numberOfInputs) {
        assert (numberOfLayers == numberOfNeuronsPerLayer.size());
        assert (numberOfLayers > 1);// number of layers must be 2 or more

        addFirstLayer(numberOfNeuronsPerLayer.get(0), numberOfInputs);
        for (int i = 1; i < numberOfLayers - 1; i++) {
            addLayer(numberOfNeuronsPerLayer.get(i), numberOfNeuronsPerLayer.get(i - 1));
        }
        addLastLayer(numberOfNeuronsPerLayer.get(numberOfLayers - 1), numberOfNeuronsPerLayer.get(numberOfLayers - 2));

    }

    private void addLastLayer(int numberOfNeurons, int numberOfInputs) {
        layers.add(new LastLayer(numberOfNeurons, numberOfInputs));
    }

    private void addFirstLayer(int numberOfNeurons, int numberOfInputs) {
        layers.add(new FirstLayer(numberOfNeurons, numberOfInputs));

    }


    private void addLayer(int numberOfNeurons, int numberOfInputs) {
        layers.add(new HiddenLayer(numberOfNeurons, numberOfInputs));
    }

    @Override
    public ArrayList<Double> feed(ArrayList<Double> X) {
        ArrayList<Double> normalizedInput = normalize(X, DataParser.getMins(), DataParser.getMaxs(), 1, 0);
        return getFirstLayer().feed(normalizedInput);
    }

    public ILayer getFirstLayer() {
        return layers.get(0);
    }

    @Override
    public ArrayList<ArrayList<Integer>> getConfusionMatrix() {
        return confusionMatrix;
    }

    @Override
    public double getAccuracy() {
        return globalAccuracy*100/nTries;
    }

    @Override
    public void learn(ArrayList<Double> X, ArrayList<Double> desiredOutput) {
        ArrayList<Double> RealOutput = feed(X);
        getLastLayer().updateError(desiredOutput);
        ArrayList<Double> normalizedInput = normalize(X, DataParser.getMins(), DataParser.getMaxs(), 1, 0);
        getFirstLayer().updateWeightsAndBias(normalizedInput);
    }

    private double calculateDiffSquared(ArrayList<Double> realOutput, ArrayList<Double> desiredOutput) {
        int size = realOutput.size();
        Double AcumulatedError = 0.0;
        for (int i = 0; i < size; i++) {
            Double diff = realOutput.get(i) - desiredOutput.get(i);
            AcumulatedError += diff * diff;
        }
        return AcumulatedError;
    }

    @Override
    public double getLoss() {
        return MSE / nTries;
    }

    @Override
    public void train(int percentageOfTraining) {
        int numOfLearningRows = DataParser.getData().size() * percentageOfTraining / 100;
        for (int i = 0; i < numOfLearningRows; i++) {
            learn(DataParser.getDataInput(i), DataParser.getOutput(i));
        }
        evaluate(numOfLearningRows);
    }

    private void evaluate(int numOfLearningRows) {
        resetErrors();
        resetConfusionMatrix();
        for (int i = numOfLearningRows; i < DataParser.getData().size(); i++) {
            ArrayList<Double> output = feed(DataParser.getDataInput(i));
            ArrayList<Double> prediction = getOneHotPrediction(output);
            int goldLabel = getIndexOfTheOutput(DataParser.getOutput(i));
            int predictedLabel = getIndexOfTheOutput(prediction);
            confusionMatrix.get(predictedLabel).set(goldLabel, confusionMatrix.get(predictedLabel).get(goldLabel) + 1);
            if (prediction.get(goldLabel) == 1.0) {
                globalAccuracy++;
            }
            updateError(output, DataParser.getOutput(i));
        }
    }

    private void resetConfusionMatrix() {
        createConfusionMatrix(getLastLayer().getNumberOfNeurons());
    }

    private void updateError(ArrayList<Double> output, ArrayList<Double> desiredOutput) {
        nTries++;
        double diffSqured = calculateDiffSquared(output, desiredOutput);
        MSE += diffSqured;
    }

    private int getIndexOfTheOutput(ArrayList<Double> output) {
        double max = 0.0;
        int maxIndex = 0;
        for (int j = 0; j < output.size(); j++) {
            if (max < output.get(j)) {
                max = output.get(j);
                maxIndex = j;
            }
        }
        return maxIndex;
    }

    private ArrayList<Double> getOneHotPrediction(ArrayList<Double> output) {
        int maxIndex = getIndexOfTheOutput(output);
        ArrayList<Double> prediction = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
        prediction.set(maxIndex, 1.0);
        return prediction;
    }

    @Override
    public void train(int percentageOfTraining, int epoch) {
        createFile("Error.txt");
        createFile("Accuracy.txt");
        for (int i = 0; i < epoch; i++) {
            train(percentageOfTraining);
            appendError(i);
            appendAcuracy(i);
        }
        createFile("Confusion.txt");
        saveConfusionMatrix();
    }

    private void appendAcuracy(int index) {
        try {
            File logFile = new File("Accuracy.txt");

            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
            String string;
            string = index + " " + getAccuracy() + '\n';
            writer.write(string);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveConfusionMatrix() {

        try {
            File logFile = new File("Confusion.txt");

            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
            String string;
            for (ArrayList<Integer> predictedClass : confusionMatrix) {
                string = "";
                for (int i = 0; i < predictedClass.size() - 1; i++) {
                    string += predictedClass.get(i) + " ";
                }
                string += Integer.toString(predictedClass.get(predictedClass.size() - 1)) + '\n';
                writer.write(string);
            }
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createFile(String fileName) {
        try {
            File logFile = new File(fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void appendError(int index) {
        try {
            //results will be saved on a file in this format
            //x y desired
            File logFile = new File("Error.txt");

            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
            String string;
            string = index + " " + getLoss() + '\n';
            writer.write(string);


            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void    resetErrors() {
        nTries = 0;
        MSE = 0;
        globalAccuracy = 0;
    }

    private ILayer getLastLayer() {
        return layers.get(layers.size() - 1);
    }

    private ArrayList<Double> normalize(ArrayList<Double> X, ArrayList<Double> dlarray, ArrayList<Double> dharray, double nh, double nl) {
        int Xsize = X.size();
        ArrayList<Double> normalizedInput = new ArrayList<>();
        for (int i = 0; i < Xsize; i++) {
            double actualX = X.get(i);
            double normalizedValue = normalizeOneInput(actualX, dlarray.get(i), dharray.get(i), nh, nl);
            normalizedInput.add(normalizedValue);
        }
        return normalizedInput;
    }

    private double normalizeOneInput(double input, double dl, double dh, double nh, double nl) {
        double normalizedValue =
                ((input - dl) * (nh - nl) /
                        (dh - dl)) + nl;
        return normalizedValue;
    }


    //private ArrayList<Integer> deNormalize(ArrayList<Double> X, int dl, int dh, Double nh, Double nl) {
    //
    //  }

}
