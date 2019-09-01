package NeuralNetwork;

import NeuralNetworks.INeuralNetwork;
import NeuralNetworks.NeuralNetwork;
import org.junit.Before;
import org.junit.Test;
import Utils.DatasetParser;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class NeuralNetworkTest {
    private DatasetParser dp;
    private INeuralNetwork NN;

    @Before
    public void Setup() {
        int numberOfLayers = 4;
        ArrayList<Integer> numberOfNeuronsPerLayer = new ArrayList<>(Arrays.asList(5, 4, 5, 3));
        int numberOfInputs = 4;
        int numberOfOutputs = 3;

        NN = new NeuralNetwork(numberOfLayers, numberOfNeuronsPerLayer, numberOfInputs, numberOfOutputs);
        NN.setData("data/bezdekIris.txt");
    }

    @Test
    public void ParsedData() {

        //dp.head(5);
        //dp.headOneHotEncoding(5);
        //dp.printMaxs();
        //dp.printMins();
    }

    @Test
    public void ItWorks() {
        NN.train(70, 10);
    }
}
