package GP.Tree;

public class AddNode extends AbstractBinaryNode {


    public AddNode(INode left, INode right) {
        super(left, right);
    }

    @Override
    public Double evaluate() {
        return left.evaluate() + right.evaluate();
    }

    @Override
    public INode copy() {
        return new AddNode(left.copy(), right.copy());
    }
}
