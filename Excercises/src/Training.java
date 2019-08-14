
import Perceptron.AbstractNeuron;
import Perceptron.BasePerceptron;
import Perceptron.LinePerceptron;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Training {

    public static int randomBetween(Random r, int low, int high) {
        return r.nextInt(high - low) + low;
    }

    public static void main(String[] args) {
        AbstractNeuron LinePerceptron = new LinePerceptron(0);
        int m = 3;
        int n = 0;
        // line is x = y
        int numberOfTrainings = 1000;
        int numberOfTests = 1000;
        int fails = 0;

        Random xGen = new Random(1);
        Random yGen = new Random(2);

        Random xTestGen = new Random(3);
        Random yTestGen = new Random(4);

        double x, y;
        int desired;

        for (int i = 0; i < numberOfTrainings; i++) {
            x = xGen.nextDouble();
            y = yGen.nextDouble();

            desired = x * m + n > y ? 1 : 0;

            if (LinePerceptron.check(x, y) != desired) {
                LinePerceptron.learn(x, y, desired);
            }
        }
        try {
            //results will be saved on a file in this format
            //x y desired
            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(
                    Calendar.getInstance().getTime());
            File logFile=new File("test"+".txt");

            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));
            String string;

            for (int i = 0; i < numberOfTests; i++) {
                x = xTestGen.nextDouble();
                y = yTestGen.nextDouble();

                desired = x * m + n > y ? 1 : 0;

                if (LinePerceptron.check(x, y) != desired) {
                    fails++;
                }
                string= Double.toString(x) +" "+Double.toString(y)+" "+Double.toString(desired)+"\n";
                writer.write (string);

            }

            writer.close();
            Process p = Runtime.getRuntime().exec("python3 src/plotLine.py");
            p.waitFor();

        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(fails);

    }
}
