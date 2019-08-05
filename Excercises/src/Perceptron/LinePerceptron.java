package Perceptron;

import java.util.Random;

public class LinePerceptron extends AbstractPerceptron {
    public LinePerceptron(){
        super(0,0,0);
        int low = -2;
        int high = 2;
        Random r = new Random(0);
        changeWeights(r.nextInt(high-low)+low,r.nextInt(high-low)+low,r.nextInt(high-low)+low);
    }
    private void changeWeights(int w1, int w2,int b){
        this.w1 = w1;
        this.w2= w2;
        this.b = b;
    }
}
