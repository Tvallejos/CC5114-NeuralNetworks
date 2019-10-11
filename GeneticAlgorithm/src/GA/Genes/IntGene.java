package GA.Genes;

public class IntGene extends AbstractGene{
    public IntGene(String alleleValue) {
        super(alleleValue);
    }

    public IntGene(int alleleValue) {
        this(Integer.toString(alleleValue));
    }
}
