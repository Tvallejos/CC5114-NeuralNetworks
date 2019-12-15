package GA.Functions;

import GA.IIndividual;
import GP.Tree.INode;

import java.util.HashMap;

public class numberFindingFitnessFunction implements IFitnessFunction {
    protected int secretNumber;
    protected HashMap<String, Double> env;

    public numberFindingFitnessFunction(int secretNumber, HashMap<String, Double> env) {
        this.secretNumber = secretNumber;
        this.env = env;
    }


    @Override
    public int run(IIndividual i) {
        INode root = i.getGenes().get(0).getNode();
        try {
            int value = root.evaluate(env).intValue();
            int dif = Math.abs(secretNumber - value);

            return Math.max(0, secretNumber - dif);
        } catch (ArithmeticException e) {
            return 0;
        }

    }

    @Override
    public boolean solutionFound(int fitness) {
        return fitness == secretNumber;
    }
}
