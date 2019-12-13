package GP.Tree;

public class MinNode extends AbstractBinaryNode {

    public MinNode(INode left, INode right) {
        super(left, right);
    }

    @Override
    public Double evaluate() {
        return Math.min(left.evaluate(), right.evaluate());
    }

    @Override
    public INode copy() {
        return new MinNode(left.copy(), right.copy());
    }

    @Override
    protected String myfunc() {
        return "min";
    }

    @Override
    public String toString() {
        return myfunc()+"("+left.toString()+","+right.toString()+")";
    }
}
