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
        Double r = right.evaluate(env);
        if (r == 0.0) {
            throw new ArithmeticException();
        }
        return left.evaluate(env) / r;
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
