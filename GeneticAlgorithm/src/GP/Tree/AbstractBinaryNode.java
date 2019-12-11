package GP.Tree;

import java.util.ArrayList;

public abstract class AbstractBinaryNode implements INode {
    protected INode left;
    protected INode right;

    public AbstractBinaryNode(INode left, INode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public abstract Double evaluate();

    @Override
    public abstract INode copy();

    @Override
    public ArrayList<INode> serialize() {
        return null;
    }
}
