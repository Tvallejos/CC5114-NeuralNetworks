package TreeLibrary;

import GP.Tree.INode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        assertEquals(evaluateAnswer(), theTestedNode.evaluate());
    }

    @Override
    public abstract INode copyAnswer();

    @Test
    @Override
    public void copy() {
        assertTrue(theTestedNode.equals(copyAnswer()));

        assertTrue(theTestedNode.equals(theTestedNode.copy()));


        assertFalse(theTestedNode==copyAnswer());
        assertFalse(theTestedNode.copy()==copyAnswer());
    }

    @Override
    public abstract ArrayList<INode> serializeAnswer();

    @Test
    @Override
    public void serialize() {
        assertEquals(serializeAnswer(), theTestedNode.serialize(new ArrayList<>()));
    }
}
