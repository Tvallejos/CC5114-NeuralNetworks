package TreeLibrary;

import GP.Tree.INode;
import GP.Tree.MinNode;
import GP.Tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class MinNodeTest extends AbstractNodeTest {
    private Double minVal, aVal;

    @Override
    public void nodeSetup() {
        minVal = -3.0;
        aVal = 7.0;
        theTestedNode = new MinNode(new TerminalNode(minVal), new TerminalNode(aVal));
    }

    @Override
    public Double evaluateAnswer() {
        return minVal;
    }

    @Override
    public INode copyAnswer() {
        return new MinNode(new TerminalNode(minVal), new TerminalNode(aVal));
    }

    @Override
    public ArrayList<INode> serializeAnswer() {
        return new ArrayList<>(
                List.of(
                        new MinNode(new TerminalNode(minVal), new TerminalNode(aVal)),
                        new TerminalNode(minVal),
                        new TerminalNode(aVal)));
    }

}
