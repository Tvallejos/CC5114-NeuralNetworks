package TreeLibrary;

import GP.Tree.INode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractNodeTest implements INodeTest {

    protected INode theTestedNode;

    @BeforeEach
    public void setup() {
        nodeSetup();
    }

    @Override
    public abstract void nodeSetup();


    @Override
    public abstract Double evaluateAnswer();

    @Test
    @Override
    public void evaluate() {
        assertEquals(evaluateAnswer(), theTestedNode.evaluate(new HashMap<>()));
    }

    @Override
    public abstract INode copyAnswer();

    @Test
    @Override
    public void copy() {
        assertTrue(theTestedNode.equals(copyAnswer()));

        assertTrue(theTestedNode.equals(theTestedNode.copy(null)));


        assertFalse(theTestedNode==copyAnswer());
        assertFalse(theTestedNode.copy(null)==copyAnswer());
    }

    @Override
    public abstract ArrayList<INode> serializeAnswer();

    @Test
    @Override
    public void serialize() {
        assertEquals(serializeAnswer(), theTestedNode.serialize(new ArrayList<>()));
    }
}
