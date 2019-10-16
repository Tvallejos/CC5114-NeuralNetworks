package GA.Functions;

import GA.Allele;
import GA.Genes.IGene;
import GA.Genes.StringGene;

import java.util.ArrayList;

public class wordGeneGenerationFunction implements IGeneGenerationFunction {
    private Allele alleleValues;

    public wordGeneGenerationFunction(Allele alleleValues){
        this.alleleValues = alleleValues;
    }

    @Override
    public IGene generateGene() {
        return new StringGene(alleleValues.getRandom());
    }

    @Override
    public ArrayList<IGene> generateGenes(int numberOfGenes) {
        ArrayList<IGene> generatedGenes = new ArrayList<>();
        for (int i = 0; i <numberOfGenes ; i++) {
            generatedGenes.add(generateGene());
        }
        return generatedGenes;
    }
}
