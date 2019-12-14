package GA.Functions;

import GA.IIndividual;
import GP.Tree.INode;

import java.util.ArrayList;
import java.util.HashMap;

public class numberFindingNoRep extends numberFindingFitnessFunction {
    public numberFindingNoRep(int secretNumber, HashMap<String, Double> env) {
        super(secretNumber, env);
    }

    @Override
    public int run(IIndividual i) {
        INode root = i.getGenes().get(0).getNode();
        ArrayList<Integer> terminals = new ArrayList<>();
        ArrayList<INode> usedTerminals = root.checkRepTerminals(new ArrayList<>());

        int value;
        for (INode node : usedTerminals) {
            value = node.evaluate(env).intValue();
            if(terminals.contains(value)){
                return 0;
            }else {
                terminals.add(value);
            }
        }
        return super.run(i);
    }
}
