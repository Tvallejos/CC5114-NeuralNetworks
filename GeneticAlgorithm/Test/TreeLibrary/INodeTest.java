package TreeLibrary;

import GP.Tree.INode;

import java.util.ArrayList;

public interface INodeTest {

    void nodeSetup();

    Double evaluateAnswer();

    void evaluate();

    INode copyAnswer();

    void copy();

    ArrayList<INode> serializeAnswer();

    void serialize();

}
