package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DatasetParser {
    ArrayList<ArrayList<Double>> Data;
    ArrayList<Double> Maxs;
    ArrayList<Double> Mins;

    public DatasetParser(String fileName) {
        Data = new ArrayList<>();
        Maxs = new ArrayList<>();
        Mins = new ArrayList<>();
        getFileIntoData(fileName);
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
            String[] splittedLine = actualLine.split(" ");
            int size = splittedLine.length;
            ArrayList<Double> actualValues = new ArrayList<>();
            for (int i = 0; i < size - 1; i++) {
                actualValues.add(Double.parseDouble(splittedLine[i]));
            }
            ArrayList<Double> oneHotEncoding = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
            oneHotEncoding.set(Integer.parseInt(splittedLine[size - 1]) - 1, 1.0);
            for (int i = 0; i < oneHotEncoding.size(); i++) {
                actualValues.add(oneHotEncoding.get(i));
            }
            Data.add(actualValues);
        }
    }


    private BufferedReader getFileIntoData(String fileName) {
        BufferedReader bufferedReader = new BufferedReader(null);
        try {
            FileReader fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            parseFile(bufferedReader);
            getMinsAndMaxs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }

    private void getMinsAndMaxs() {
        for (int i = 0; i < Data.get(0).size(); i++) {
            double actualValue = Data.get(0).get(i);
            Mins.add(actualValue);
            Maxs.add(actualValue);
        }
        for (int i = 1; i < Data.size(); i++) {
            compareMinsAndMax(Data.get(i));
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
}
