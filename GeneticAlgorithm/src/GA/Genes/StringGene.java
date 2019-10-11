
package GA.Genes;

public class StringGene extends AbstractGene {

    public StringGene(String alleleValue){
        super(alleleValue);
    }

    @Override
    public int getIntValue() {
        return -1;
    }

}
