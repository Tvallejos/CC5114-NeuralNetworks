package GP.Tree;

import java.util.HashMap;

public class AddNode extends AbstractBinaryNode {


    public AddNode(INode left, INode right) {
        super(left, right);
    }

    public AddNode(INode left, INode right, IBinaryNode father) {
        super(left, right, father);
    }

    @Override
    public Double evaluate(HashMap<String, Double> env) {
        return left.evaluate(env) + right.evaluate(env);
    }

    @Override
    public INode copy(IBinaryNode father) {
        IBinaryNode CopyNode = new AddNode(null, null, father);
        return createCopy(CopyNode, left, right);
    }


    @Override
    protected String myfunc() {
        return "+";
    }
}
