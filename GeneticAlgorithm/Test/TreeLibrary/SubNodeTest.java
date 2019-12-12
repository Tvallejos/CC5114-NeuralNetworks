package TreeLibrary;

import GP.Tree.INode;
import GP.Tree.SubNode;
import GP.Tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class SubNodeTest extends AbstractNodeTest {
    private Double first, second;

    @Override
    public void nodeSetup() {
        first = 7.0;
        second = 2.0;
        theTestedNode = new SubNode(new TerminalNode(first), new TerminalNode(second));
    }

    @Override
    public Double evaluateAnswer() {
        return first - second;
    }

    @Override
    public INode copyAnswer() {
        return new SubNode(new TerminalNode(first), new TerminalNode(second));

    }

    @Override
    public ArrayList<INode> serializeAnswer() {
        return new ArrayList<>(
                List.of(
                        new SubNode(new TerminalNode(first), new TerminalNode(second)),
                        new TerminalNode(first),
                        new TerminalNode(second)
                ));
    }
}
