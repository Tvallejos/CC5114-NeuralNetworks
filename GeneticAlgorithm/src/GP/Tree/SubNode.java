package GP.Tree;

import java.util.HashMap;

public class SubNode extends AbstractBinaryNode {

    public SubNode(INode left, INode right) {
        super(left, right);
    }
    public SubNode(INode left,INode right, IBinaryNode father){
        super(left, right, father);
    }
    @Override
    public Double evaluate(HashMap<String, Double> env) {
        return left.evaluate(env) - right.evaluate(env);
    }

    @Override
    public INode copy(IBinaryNode father) {
        IBinaryNode CopyNode = new SubNode(null, null, father);
        return createCopy(CopyNode, left, right);
    }

    @Override
    protected String myfunc() {
        return "-";
    }
}
