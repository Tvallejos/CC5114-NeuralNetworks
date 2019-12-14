package GA.Functions;

import GA.IIndividual;
import GP.Tree.INode;

public class numberFindingPlusPunishFitnessFunction extends numberFindingFitnessFunction {


    public numberFindingPlusPunishFitnessFunction(int secretNumber) {
        super(secretNumber);
    }


    @Override
    public int run(IIndividual i) {
        int depth = i.getGenes().get(0).getNode().getDepth();
        int depthPunishment = depth * depth;
        return Math.max(super.run(i) - depthPunishment, 0);
    }
}
