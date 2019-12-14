package GP.Tree;

import java.util.ArrayList;
import java.util.HashMap;

public class VariableNode extends AbstractNode {
    private String symbol;
    private Double eval;

    public VariableNode(IBinaryNode father, String symbol) {
        super(father);
        this.symbol = symbol;
        eval = -25000000.00;
    }

    public VariableNode(String symbol) {
        super(null);
        this.symbol = symbol;
    }

    @Override
    public Double evaluate(HashMap<String, Double> env) {
        eval = env.get(symbol);
        return eval;
    }

    @Override
    public INode copy(IBinaryNode father) {
        return new VariableNode(father, symbol);
    }


    @Override
    public ArrayList<INode> checkRepTerminals(ArrayList<INode> Acc) {
        Acc.add(this);
        return Acc;
    }

    @Override
    public String toString() {
        return symbol + "-> " + Double.toString(eval);
    }
}
