package GP.Tree;

import java.util.ArrayList;

public class TerminalNode extends AbstractNode {
    private Double value;

    public TerminalNode(Double value) {
        this.value = value;
    }

    @Override
    public Double evaluate() {
        return value;
    }

    @Override
    public INode copy() {
        return new TerminalNode(value);
    }

    @Override
    public ArrayList<INode> serialize(ArrayList<INode> Acc) {
        Acc.add(this);
        return Acc;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TerminalNode) {
            return super.equals(o) && value == ((TerminalNode) o).evaluate();
        }

        return false;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
