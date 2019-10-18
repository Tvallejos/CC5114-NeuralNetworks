package GA.Functions;

import GA.Allele;
import GA.Genes.IGene;
import GA.Genes.IntGene;
import GA.Genes.StringGene;
import GA.IIndividual;

import java.util.ArrayList;
import java.util.Random;

public class zeroOneKnapsackGeneGenerationFunction extends stdGeneGenerationFunction {



    public zeroOneKnapsackGeneGenerationFunction(Allele alleleValues, int chromosomeLength) {
        super(alleleValues, chromosomeLength);
    }

    @Override
    public ArrayList<IGene> generateGenes(int numberOfGenes, int seed) {
        ArrayList<IGene> generatedGenes = new ArrayList<>();
        Random r = new Random(seed);
        IGene intGene;
        for (int i = 0; i < numberOfGenes; i++) {
            intGene = new IntGene(r.nextInt(2));
            generatedGenes.add(intGene);
        }

        return generatedGenes;
    }

    /*@Override
    public String individualToString(IIndividual iIndividual) {


    }

     */
}
