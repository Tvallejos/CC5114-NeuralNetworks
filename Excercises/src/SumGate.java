import Perceptron.AbstractPerceptron;
import Perceptron.NandPerceptron;

public class SumGate {
    AbstractPerceptron Nand;

    int sum;
    int carry;

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

    public void sum(int x1, int x2) {
        isInputBinary(x1, x2);
        int ans1, ans2, ans3;

        ans1 = Nand.check(x1, x2);
        ans2 = Nand.check(x1, ans1);
        ans3 = Nand.check(ans1, x2);

        sum = Nand.check(ans2, ans3);
        carry = Nand.check(ans1, ans1);
    }

    private void isInputBinary(int x1, int x2) {
        assert (x1 == 0 || x1 == 1);
        assert (x2 == 0 || x2 == 1);
    }


    public int getSum() {
        return sum;
    }

    public int getCarry() {
        return carry;
    }
}
