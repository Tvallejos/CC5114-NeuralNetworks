package Genes;

import GA.Genes.IntGene;

public class IntGeneTest extends AbstractGeneTests {

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
