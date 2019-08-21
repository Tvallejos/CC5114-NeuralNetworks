
import Perceptron.BasePerceptron;
import Perceptron.NandPerceptron;

import java.util.ArrayList;

public class SumGate {
    BasePerceptron Nand;

    double sum;
    double carry;

    // x1----------------------- NAND (----)(ans2)
    //    |                   -- NAND (----)-----|
    //    -----NAND (-----    |                  |---NAND(--)
    //              (ans1)  )-.                               )-- SUM
    //    -----NAND (-----    |                  |---NAND(--)
    //    |                   .-NAND-(-----)     |
    //    |                   |       (ans3)   )-|
    // x2 ----------------------NAND-(-----)
    //                        |
    //                        .----------NAND(---)
    //                        |----------NAND(---)-- CARRY
    public SumGate() {
        Nand = new NandPerceptron();
    }

    public ArrayList<Double> checkInt(Double x1, Double x2) {
        ArrayList<Double> input1 = new ArrayList<>();
        input1.add(x1);
        input1.add(x2);
        return input1;
    }

    public void sum(Double x1, Double x2) {
        isInputBinary(x1, x2);
        double ans1, ans2, ans3;


        ans1 = Nand.feed(checkInt(x1, x2));
        ans2 = Nand.feed(checkInt(x1, ans1));
        ans3 = Nand.feed(checkInt(ans1, x2));

        ArrayList<Double> input4 = new ArrayList<>();
        input4.add(ans2);
        input4.add(ans3);

        sum = Nand.feed(checkInt(ans2, ans3));
        carry = Nand.feed(checkInt(ans1, ans1));
    }

    private void isInputBinary(Double x1, Double x2) {
        assert (x1 == 0 || x1 == 1);
        assert (x2 == 0 || x2 == 1);
    }


    public double getSum() {
        return sum;
    }

    public double getCarry() {
        return carry;
    }
}
