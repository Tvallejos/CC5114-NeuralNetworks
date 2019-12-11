package GP.Tree;

public class SubNode extends AbstractBinaryNode {

    public SubNode(INode left, INode right) {
        super(left, right);
    }

    @Override
    public Double evaluate() {
        return left.evaluate() - right.evaluate();
    }

    @Override
    public INode copy() {
        return new SubNode(left.copy(), right.copy());
    }
}
