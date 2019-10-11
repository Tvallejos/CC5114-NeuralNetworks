package GA.Genes;
import GA.Genes.IGene;

public abstract class AbstractGene implements IGene {

    protected String alleleValue;

    public AbstractGene(String alleleValue) {
        this.alleleValue= alleleValue;
    }

    public String getStringValue(){
        return alleleValue;
    }

    public int getIntValue(){
        return Integer.parseInt(alleleValue);
    }
}
