package GP.Tree;

import java.util.HashMap;

public class DivisionNode extends AbstractBinaryNode {

    public DivisionNode(INode left, INode right) {
        super(left, right);
    }

    public DivisionNode(IBinaryNode father, INode left, INode right) {
        super(left, right, father);
    }

    @Override
    public Double evaluate(HashMap<String, Double> env) {
        return left.evaluate(env) / right.evaluate(env);
    }

    @Override
    public INode copy(IBinaryNode father) {
        IBinaryNode CopyNode = new DivisionNode(null, null, father);
        return createCopy(CopyNode, left, right);
    }

    @Override
    protected String myfunc() {
        return "/";
    }
}
