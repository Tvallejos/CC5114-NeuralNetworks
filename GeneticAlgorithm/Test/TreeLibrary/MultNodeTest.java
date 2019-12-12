package TreeLibrary;

import GP.Tree.INode;
import GP.Tree.MultNode;
import GP.Tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class MultNodeTest extends AbstractNodeTest {
    private Double aVal, otherVal;

    @Override
    public void nodeSetup() {
        aVal = 5.0;
        otherVal = 8.0;
        theTestedNode = new MultNode(new TerminalNode(aVal), new TerminalNode(otherVal));
    }

    @Override
    public Double evaluateAnswer() {
        return aVal * otherVal;
    }

    @Override
    public INode copyAnswer() {
        return new MultNode(new TerminalNode(aVal), new TerminalNode(otherVal));
    }

    @Override
    public ArrayList<INode> serializeAnswer() {
        return new ArrayList<>(
                List.of(
                        new MultNode(new TerminalNode(aVal), new TerminalNode(otherVal)),
                        new TerminalNode(aVal),
                        new TerminalNode(otherVal)));
    }
}
