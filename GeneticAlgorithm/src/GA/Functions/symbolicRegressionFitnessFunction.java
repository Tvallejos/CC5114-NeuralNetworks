package GA.Functions;

import GA.IIndividual;
import GP.Tree.INode;

import java.util.HashMap;

public class symbolicRegressionFitnessFunction implements IFitnessFunction {

    private INode function;
    private int from, to;

    public symbolicRegressionFitnessFunction(INode toFindFunction, int from, int to) {
        assert (from < to);
        this.function = toFindFunction;
        this.from = from;
        this.to = to;
    }

    @Override
    public int run(IIndividual i) {
        INode root = i.getGenes().get(0).getNode();
        Double diff = 0.0;

        for (int j = from; j < to; j++) {
            HashMap env = new HashMap<String, Double>();
            env.put("x", Double.valueOf(j));


            Double trueValue = function.evaluate(env);
            Double predictedValue = root.evaluate(env);
            diff += Math.abs(trueValue - predictedValue);

        }


        return (int) Math.max(0.0, 100 - diff);
    }

    @Override
    public boolean solutionFound(int fitness) {
        return fitness >= 90;
    }
}
