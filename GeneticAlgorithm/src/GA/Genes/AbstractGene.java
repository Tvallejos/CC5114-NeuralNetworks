package GA.Genes;

// TODO Abstract Gene documentation
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

    @Override
    public boolean equals(Object o){
        if(o instanceof IGene){
            return alleleValue.equals(((IGene) o).getStringValue());
        }
        return false;
    }
}
