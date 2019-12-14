package GP.Tree;

import java.util.HashMap;

public class MinNode extends AbstractBinaryNode {

    public MinNode(INode left, INode right) {
        super(left, right);
    }
    public MinNode(INode left,INode right, IBinaryNode father){
        super(left, right, father);
    }
    @Override
    public Double evaluate(HashMap<String, Double> env) {
        return Math.min(left.evaluate(env), right.evaluate(env));
    }

    @Override
    public INode copy(IBinaryNode father) {
        IBinaryNode CopyNode = new MinNode(null, null, father);
        return createCopy(CopyNode, left, right);
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
