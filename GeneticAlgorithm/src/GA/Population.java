package GA;

import GA.Genes.IGene;
import GA.Genes.StringGene;

import java.util.ArrayList;
import java.util.Random;

public class Population {
    private ArrayList<Individual> individuals;
    private int populationSize;
    private Allele alleleValues;
    private int chromosomeLength;

    public Population(int chromosomeLength, int populationSize, ArrayList<String> alleleValues, int seed) {
        this.alleleValues = new Allele(alleleValues);
        this.chromosomeLength = chromosomeLength;
        this.populationSize = populationSize;
        individuals = new ArrayList<>();
        createRandomIndividuals(seed);
    }

    public Population(int chromosomeLength, int populationSize, ArrayList<String> alleleValues) {
        this(chromosomeLength, populationSize, alleleValues, new Random().nextInt());
    }

    private void createRandomIndividuals(int seed) {
        Random r = new Random(seed);

        for (int i = 0; i < populationSize; i++) {
            Individual newIndividual = createRandomIndividual(r.nextInt());
            individuals.add(newIndividual);
        }
    }

    public Allele getAlleleValues() {
        return alleleValues;
    }

    public int getChromosomeLength() {
        return chromosomeLength;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public ArrayList<Individual> getIndividuals() {
        return individuals;
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
