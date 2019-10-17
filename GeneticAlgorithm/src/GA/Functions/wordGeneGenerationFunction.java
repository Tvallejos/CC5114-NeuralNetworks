package GA.Functions;

import GA.Allele;
import GA.Genes.IGene;
import GA.Genes.StringGene;
import GA.IIndividual;
import GA.Individual;

import java.util.ArrayList;
import java.util.Random;

public class wordGeneGenerationFunction implements IGeneGenerationFunction {
    private Allele alleleValues;
    private int chromosomeLength;

    public wordGeneGenerationFunction(Allele alleleValues, int chromosomeLength) {
        this.alleleValues = alleleValues;
        this.chromosomeLength = chromosomeLength;
    }

    @Override
    public IGene generateGene() {
        return new StringGene(alleleValues.getRandom());
    }

    @Override
    public ArrayList<IGene> generateGenes(int numberOfGenes) {
        ArrayList<IGene> generatedGenes = new ArrayList<>();
        for (int i = 0; i < numberOfGenes; i++) {
            generatedGenes.add(generateGene());
        }
        return generatedGenes;
    }


    public ArrayList<IIndividual> initializePopulation(int seed, int populationSize) {
        Random r = new Random(seed);
        ArrayList individuals = new ArrayList();
        for (int i = 0; i < populationSize; i++) {
            Individual newIndividual = createRandomIndividual(r.nextInt());
            individuals.add(newIndividual);
        }
        return individuals;
    }

    public ArrayList<IIndividual> initializePopulation(int populationSize) {
        return initializePopulation(new Random().nextInt(), populationSize);
    }

    @Override
    public Allele getAlleleValues() {
        return alleleValues;
    }

    @Override
    public int getChomosomeLength() {
        return chromosomeLength;
    }

    private Individual createRandomIndividual(int seed) {
        ArrayList<IGene> chromosome = new ArrayList<>();
        Random r = new Random(seed);
        StringGene actualStringGene;
        String allele;
        for (int i = 0; i < chromosomeLength; i++) {
            allele = alleleValues.getRandom(r.nextInt());
            actualStringGene = new StringGene(allele);
            chromosome.add(actualStringGene);
        }
        return new Individual(chromosome);
    }

}
