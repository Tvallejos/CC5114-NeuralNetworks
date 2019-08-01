package Perceptron;

public abstract class AbstractPerceptron implements Perceptron{
    private int w1;
    private int w2;
    private int b;

    AbstractPerceptron(int w1,int w2,int b){
        this.w1 = w1;
        this.w2 = w2;
        this.b = b;

    }

    @Override
    public int check(int x1, int x2) {
        // if weighted sum + b <= 0 -> false
        if(x1*w1 + x2*w2 + b <= 0){
            return 0;}
        else{
            return 1;
        }

    }

    public int getW1() {
        return w1;
    }

    public int getW2() {
        return w2;
    }

    public int getB() {
        return b;
    }
}
