package GP.Tree;

import java.util.ArrayList;

public class AbstractNode implements INode{
    protected INode left;
    protected INode right;
    protected IOperation operation;
    public AbstractNode(IOperation operation){
        this.

    }
    @Override
    public Double evaluate(Double x, Double y) {
        return null;
    }

    @Override
    public ITree copy() {
        return null;
    }

    @Override
    public ArrayList<INode> serialize() {
        return null;
    }
}
