package GA.Functions;

import GA.IIndividual;
import GP.Tree.INode;

public class numberFindingFitnessFunction implements IFitnessFunction {
    private int secretNumber;

    public numberFindingFitnessFunction(int secretNumber) {
        this.secretNumber = secretNumber;
    }


    @Override
    public int run(IIndividual i) {
        INode root = i.getGenes().get(0).getNode();
        int value = root.evaluate().intValue();
        int dif = Math.abs(secretNumber - value);

        return Math.max(0, secretNumber - dif);
    }


    @Override
    public boolean solutionFound(int fitness) {
        return fitness == secretNumber;
    }
}
