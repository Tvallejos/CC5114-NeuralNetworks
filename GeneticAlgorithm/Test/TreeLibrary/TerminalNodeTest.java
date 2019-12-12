package TreeLibrary;

import GP.Tree.INode;
import GP.Tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class TerminalNodeTest extends AbstractNodeTest{

    private Double value;

    @Override
    public void nodeSetup() {
        value = 5.0;
        theTestedNode = new TerminalNode(value);
    }

    @Override
    public Double evaluateAnswer() {
        return value;
    }

    @Override
    public INode copyAnswer() {
        return new TerminalNode(value);
    }

    @Override
    public ArrayList<INode> serializeAnswer() {
        return new ArrayList<>(List.of(new TerminalNode(value)));
    }
}
