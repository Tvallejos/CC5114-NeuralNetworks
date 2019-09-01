package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DatasetParser {
    ArrayList<ArrayList<ArrayList<Double>>> Data;
    ArrayList<Double> Maxs;
    ArrayList<Double> Mins;

    public DatasetParser(String fileName) {
        Data = new ArrayList<>();
        Maxs = new ArrayList<>();
        Mins = new ArrayList<>();
        getFileIntoData(fileName);
        shuffleData();
    }

    public ArrayList<Double> getOutput(int i) {
        return Data.get(i).get(1);
    }

    private void shuffleData() {
        Collections.shuffle(Data);
    }

    public ArrayList<ArrayList<ArrayList<Double>>> getData() {
        return Data;
    }

    public ArrayList<Double> getDataInput(int i){
        return Data.get(i).get(0);
    }

    public ArrayList<Double> getMaxs() {
        return Maxs;
    }

    public ArrayList<Double> getMins() {
        return Mins;
    }

    /**
     * this method only works with
     * https://archive.ics.uci.edu/ml/datasets/iris
     *
     * @param bufferedReader
     * @return
     * @throws IOException
     */
    private void parseFile(BufferedReader bufferedReader) throws IOException {
        String actualLine;
        while ((actualLine = bufferedReader.readLine()) != null) {
            String[] splittedLine = actualLine.split(",");
            int size = splittedLine.length;
            ArrayList<Double> actualValues = new ArrayList<>();
            for (int i = 0; i < size - 1; i++) {
                actualValues.add(Double.parseDouble(splittedLine[i]));
            }
            ArrayList<ArrayList<Double>> actualRow = new ArrayList<>();

            actualRow.add(actualValues);

            int Category = 0;
            if (splittedLine[size - 1].equals("Iris-setosa")) {
                Category = 1;
            } else if (splittedLine[size - 1].equals("Iris-versicolor")) {
                Category = 2;
            } else if (splittedLine[size - 1].equals("Iris-virginica")) {
                Category = 3;
            }


            ArrayList<Double> oneHotEncoding = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
            if (Category == 0) {
                System.out.println(splittedLine[size - 1]);
            }
            oneHotEncoding.set(Category - 1, 1.0);
            actualRow.add(oneHotEncoding);
            Data.add(actualRow);

        }
    }


    private void getFileIntoData(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            parseFile(bufferedReader);
            getMinsAndMaxs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getMinsAndMaxs() {
        for (int i = 0; i < Data.get(0).get(0).size(); i++) {
            double actualValue = Data.get(0).get(0).get(i);
            Mins.add(actualValue);
            Maxs.add(actualValue);
        }
        for (int i = 1; i < Data.size(); i++) {
            compareMinsAndMax(Data.get(i).get(0));
        }


    }

    private void compareMinsAndMax(ArrayList<Double> actualRow) {
        for (int i = 0; i < actualRow.size(); i++) {
            double actualValue = actualRow.get(i);
            if (actualValue < Mins.get(i)) {
                Mins.set(i, actualValue);
            }
            if (Maxs.get(i) < actualValue) {
                Maxs.set(i, actualValue);
            }
        }
    }

    public void head(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("Row number " + i);
            ArrayList<Double> actualRow = Data.get(i).get(0);
            for (int j = 0; j < actualRow.size(); j++) {
                double actualValue = actualRow.get(j);
                System.out.print(actualValue + " ");
            }
            System.out.println("");
        }
    }

    public void headOneHotEncoding(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("Output " + i);
            ArrayList<Double> actualRow = getOutput(i);
            for (int j = 0; j < actualRow.size(); j++) {
                double actualValue = actualRow.get(j);
                System.out.print(actualValue + " ");
            }
            System.out.println("");
        }
    }

    public void printMaxs() {
        for (int i = 0; i < Maxs.size(); i++) {
            System.out.print(Maxs.get(i) + " ");
        }
        System.out.println("");
    }

    public void printMins() {
        for (int i = 0; i < Mins.size(); i++) {
            System.out.print(Mins.get(i) + " ");
        }
        System.out.println("");
    }

}
