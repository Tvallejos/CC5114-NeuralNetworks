package GP.Tree;

import java.util.ArrayList;
import java.util.HashMap;

public class TerminalNode extends AbstractNode {
    private Double value;

    public TerminalNode(Double value) {
        this(value, null);
    }

    public TerminalNode(Double value, IBinaryNode father) {
        super(father);
        this.value = value;
    }

    @Override
    public Double evaluate(HashMap<String, Double> env) {
        return value;
    }

    @Override
    public INode copy(IBinaryNode father) {
        return new TerminalNode(value, father);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TerminalNode) {
            return super.equals(o) && value == ((TerminalNode) o).evaluate(new HashMap<>());
        }

        return false;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public ArrayList<INode> checkRepTerminals(ArrayList<INode> Acc) {
        Acc.add(this);
        return Acc;
    }
}
