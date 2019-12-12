package TreeLibrary;

import GP.Tree.INode;
import GP.Tree.MaxNode;
import GP.Tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class MaxNodeTest extends AbstractNodeTest {

    private Double maxVal, aVal;

    @Override
    public void nodeSetup() {
        maxVal = 10.0;
        aVal = 5.0;

        theTestedNode = new MaxNode(new TerminalNode(maxVal), new TerminalNode(aVal));
    }

    @Override
    public Double evaluateAnswer() {
        return maxVal;
    }

    @Override
    public INode copyAnswer() {
        return new MaxNode(new TerminalNode(maxVal), new TerminalNode(aVal));
    }

    @Override
    public ArrayList<INode> serializeAnswer() {
        return new ArrayList<>(
                List.of(
                        new MaxNode(new TerminalNode(maxVal), new TerminalNode(aVal)),
                        new TerminalNode(maxVal),
                        new TerminalNode(aVal)));
    }
}
