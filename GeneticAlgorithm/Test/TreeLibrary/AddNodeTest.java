package TreeLibrary;

import GP.Tree.AddNode;
import GP.Tree.INode;
import GP.Tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class AddNodeTest extends AbstractNodeTest {
    private Double first, second;

    @Override
    public void nodeSetup() {
        first = 5.0;
        second = 8.0;
        theTestedNode = new AddNode(new TerminalNode(first), new TerminalNode(second));
    }

    @Override
    public Double evaluateAnswer() {
        return first + second;
    }

    @Override
    public INode copyAnswer() {
        return new AddNode(new TerminalNode(first), new TerminalNode(second));

    }

    @Override
    public ArrayList<INode> serializeAnswer() {
        return new ArrayList<>(
                List.of(
                        new AddNode(new TerminalNode(first), new TerminalNode(second)),
                        new TerminalNode(first),
                        new TerminalNode(second)
                ));
    }
}
