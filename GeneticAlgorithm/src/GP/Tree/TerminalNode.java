package GP.Tree;

import java.util.ArrayList;

public class TerminalNode implements INode {
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
    public ArrayList<INode> serialize() {
        return null;
    }
}
