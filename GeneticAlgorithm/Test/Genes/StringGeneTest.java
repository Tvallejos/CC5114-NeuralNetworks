package Genes;
import GA.Genes.StringGene;

public class StringGeneTest extends AbstractGeneTests{

    @Override
    public void geneSetup(){
        testedGene = new StringGene("red");
    }


    public String getStringValueAnswer(){
        return "red";
    }

    @Override
    public int getIntValueAnswer() {
        return -1;
    }
}
