package GP.Tree;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryNode extends AbstractNode{
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

        ArrayList<INode> toADD = new ArrayList<>(List.of(left, right));
        Acc.addAll(toADD);
        ArrayList<INode> leftSerialized = left.serialize(Acc);
        ArrayList<INode> rightSerialized = right.serialize(leftSerialized);

        return rightSerialized;

    }
}
