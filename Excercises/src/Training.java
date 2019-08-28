
import Perceptron.LinePerceptron;
import Perceptron.INeuron;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Training {

    public static int randomBetween(Random r, int low, int high) {
        return r.nextInt(high - low) + low;
    }

    public static void main(String[] args) {
        INeuron LinePerceptron = new LinePerceptron(0);
        int m = 1;
        int n = 0;
        // line is x = y
        int numberOfTrainings = 1000;
        int epoch = 1;
        int numberOfTests = 100;

        int fails = 0;
        Random xGen = new Random(0);
        Random yGen = new Random(1);
        Random xTestGen = new Random(2);
        Random yTestGen = new Random(3);
        int desired;
        ArrayList<Double> inputX = new ArrayList<>();
        ArrayList<Double> inputY = new ArrayList<>();
        ArrayList<Double> inputTestX = new ArrayList<>();
        ArrayList<Double> inputTestY = new ArrayList<>();

        ArrayList<Double> actualInput = new ArrayList<>();
        actualInput.add(-1.0);
        actualInput.add(-1.0);
        //input generation and test generation
        for (int number = 0; number < numberOfTrainings; number++) {
            inputX.add(xGen.nextDouble());
            inputY.add(yGen.nextDouble());
        }
        for (int number = 0; number < numberOfTests; number++) {
            inputTestX.add(xGen.nextDouble());
            inputTestY.add(yGen.nextDouble());
        }


        for (int j = 0; j < epoch; j++) {


            for (int i = 0; i < numberOfTrainings; i++) {


                desired = inputX.get(i) * m + n > inputY.get(i) ? 1 : 0;

                actualInput.set(0, inputX.get(i));
                actualInput.set(1, inputY.get(i));

                LinePerceptron.learn(actualInput, desired);

            }
        }
        try {
            //results will be saved on a file in this format
            //x y desired
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(
                    Calendar.getInstance().getTime());
            File logFile = new File("test" + ".txt");

            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));
            String string;

            for (int i = 0; i < numberOfTests; i++) {
                desired = inputTestX.get(i) * m + n > inputTestY.get(i) ? 1 : 0;

                actualInput.set(0, inputTestX.get(i));
                actualInput.set(1, inputTestY.get(i));

                if (LinePerceptron.feed(actualInput) != desired) {
                    fails++;
                }
                string = Double.toString(inputTestX.get(i)) + " " + Double.toString(inputTestY.get(i)) + " " + Double.toString(LinePerceptron.feed(actualInput)) + "\n";
                writer.write(string);

            }

            writer.close();
            Process p = Runtime.getRuntime().exec("python src/plotLine.py");
            p.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(fails);
    }
}
