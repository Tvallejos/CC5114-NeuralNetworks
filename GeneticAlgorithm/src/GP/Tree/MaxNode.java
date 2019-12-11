package GP.Tree;

public class MaxNode extends AbstractBinaryNode {

    public MaxNode(INode left, INode right) {
        super(left, right);
    }

    @Override
    public Double evaluate() {
        return Math.max(left.evaluate(), right.evaluate());
    }

    @Override
    public INode copy() {
        return new MaxNode(left.copy(), right.copy());
    }
}
