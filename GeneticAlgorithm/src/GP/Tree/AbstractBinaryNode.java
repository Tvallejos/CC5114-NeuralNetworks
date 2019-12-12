package GP.Tree;

import java.util.ArrayList;

public abstract class AbstractBinaryNode extends AbstractNode {
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
    public ArrayList<INode> serialize(ArrayList<INode> Acc) {

        Acc.add(this);
        ArrayList<INode> leftSerialized = left.serialize(Acc);
        ArrayList<INode> rightSerialized = right.serialize(leftSerialized);

        return rightSerialized;

    }

    private INode getLeft() {
        return left;
    }

    private INode getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof AbstractBinaryNode) {
            return super.equals(o) &&
                    left.equals(((AbstractBinaryNode) o).getLeft()) &&
                    right.equals(((AbstractBinaryNode) o).getRight());
        }

        return false;
    }
}
