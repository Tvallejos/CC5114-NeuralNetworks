package Genes;

import GA.Genes.IntGene;
import org.junit.jupiter.api.BeforeEach;

public class IntGeneTest extends AbstractGeneTests {

    @BeforeEach
    @Override
    public void geneSetup() {
        testedGene = new IntGene(3);
    }

    @Override
    public String getStringValueAnswer() {
        return "3";
    }

    @Override
    public int getIntValueAnswer() {
        return 3;
    }
}
