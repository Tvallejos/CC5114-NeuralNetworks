package GP.Tree;

public class MaxNode extends AbstractBinaryNode {

    public MaxNode(INode left, INode right) {
        super(left, right);
    }

    public MaxNode(INode left,INode right, IBinaryNode father){
        super(left, right, father);
    }
    @Override
    public Double evaluate() {
        return Math.max(left.evaluate(), right.evaluate());
    }

    @Override
    public INode copy(IBinaryNode father) {
        IBinaryNode CopyNode = new MaxNode(null, null, father);
        return createCopy(CopyNode, left, right);
    }

    @Override
    protected String myfunc() {
        return "max";
    }

    @Override
    public String toString() {
        return myfunc()+"("+left.toString()+","+right.toString()+")";
    }
}
