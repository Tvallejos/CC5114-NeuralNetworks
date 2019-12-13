package GP.Tree;

public class MultNode extends AbstractBinaryNode {

    public MultNode(INode left, INode right) {
        super(left, right);
    }

    public MultNode(INode left, INode right, IBinaryNode father) {
        super(left, right, father);
    }

    @Override
    public Double evaluate() {
        return left.evaluate() * right.evaluate();
    }

    @Override
    public INode copy(IBinaryNode father) {
        IBinaryNode CopyNode = new MultNode(null, null, father);
        return createCopy(CopyNode, left, right);
    }

    @Override
    protected String myfunc() {
        return "*";
    }
}
