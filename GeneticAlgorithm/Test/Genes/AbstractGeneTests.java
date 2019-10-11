package Genes;

import GA.Genes.IGene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractGeneTests implements IGeneTest {
    protected IGene testedGene;


    public abstract void geneSetup();

    public abstract String getStringValueAnswer();

    public abstract int getIntValueAnswer();

    @BeforeEach
    void setup(){
        geneSetup();
    }

    @Test
    @Override
    public void getStringValueTest() {
        assertEquals(getStringValueAnswer(), testedGene.getStringValue());
    }

    @Test
    @Override
    public void getIntValueTest() {
        assertEquals(getIntValueAnswer(), testedGene.getIntValue());
    }
}
