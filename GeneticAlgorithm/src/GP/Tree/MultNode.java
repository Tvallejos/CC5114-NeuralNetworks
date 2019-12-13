package GP.Tree;

public class MultNode extends AbstractBinaryNode {

    public MultNode(INode left, INode right) {
        super(left, right);
    }

    @Override
    public Double evaluate() {
        return left.evaluate() * right.evaluate();
    }

    @Override
    public INode copy() {
        return new MultNode(left.copy(), right.copy());
    }

    @Override
    protected String myfunc() {
        return "*";
    }
}
