package GP.Tree;

import java.util.ArrayList;

public abstract class AbstractBinaryNode extends AbstractNode implements IBinaryNode {
    protected INode left;
    protected INode right;

    public AbstractBinaryNode(INode left, INode right) {
        this(left, right, null);
    }

    public AbstractBinaryNode(INode left, INode right, IBinaryNode father) {
        super(father);
        this.left = left;
        this.right = right;
    }

    @Override
    public abstract Double evaluate();

    @Override
    public abstract INode copy(IBinaryNode father);


    @Override
    public IBinaryNode getFather() {
        if (father == null) {
            return this;
        }
        return super.getFather();
    }

    @Override
    public ArrayList<INode> serialize(ArrayList<INode> Acc) {

        Acc.add(this);
        ArrayList<INode> leftSerialized = left.serialize(Acc);
        ArrayList<INode> rightSerialized = right.serialize(leftSerialized);

        return rightSerialized;

    }

    public INode getLeft() {
        return left;
    }

    public INode getRight() {
        return right;
    }

    @Override
    public void setLeft(INode left) {
        this.left = left;
    }

    @Override
    public void setRight(INode right) {
        this.right = right;
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

    @Override
    public String toString() {
        return "(" + left.toString() + this.myfunc() + right.toString() + ")";
    }

    protected abstract String myfunc();

    protected INode createCopy(IBinaryNode copyNode, INode left, INode right) {
        copyNode.setLeft(left.copy(copyNode));
        copyNode.setRight(right.copy(copyNode));
        return copyNode;
    }

    @Override
    public int getDepth() {
        return 1 + Math.max(left.getDepth(), right.getDepth());
    }
}
