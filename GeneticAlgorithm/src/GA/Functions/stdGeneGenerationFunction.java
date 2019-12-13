package GA.Functions;

import GA.Allele;
import GA.Genes.IGene;
import GA.Genes.StringGene;
import GA.IIndividual;
import GA.Individual;

import java.util.ArrayList;
import java.util.Random;

public class stdGeneGenerationFunction extends AbstractGeneGenerationFunction {
    protected Allele alleleValues;
    protected int chromosomeLength;

    public stdGeneGenerationFunction(Allele alleleValues, int chromosomeLength) {
        this.alleleValues = alleleValues;
        this.chromosomeLength = chromosomeLength;
    }

    @Override
    public String individualToString(IIndividual iIndividual) {
        ArrayList<IGene> genes = iIndividual.getGenes();
        String individualAsString = "";
        for (IGene gene : genes) {
            individualAsString = individualAsString + gene.getStringValue();
        }
        return individualAsString;
    }

    @Override
    public IGene generateGene() {
        return generateGene(new Random().nextInt());
    }

    public IGene generateGene(int seed) {
        return generateGenes(1,seed).get(0);
    }

    @Override
    public ArrayList<IGene> generateGenes(int numberOfGenes) {
        return generateGenes(numberOfGenes, new Random().nextInt());
    }

    public ArrayList<IGene> generateGenes(int numberOfGenes, int seed) {
        ArrayList<IGene> generatedGenes = new ArrayList<>();
        Random r = new Random(seed);
        StringGene actualStringGene;
        String allele;
        for (int i = 0; i < numberOfGenes; i++) {
            allele = alleleValues.getRandom(r.nextInt());
            actualStringGene = new StringGene(allele);
            generatedGenes.add(actualStringGene);
        }

        return generatedGenes;
    }

    @Override
    public Allele getAlleleValues() {
        return alleleValues;
    }

    @Override
    public int getChomosomeLength() {
        return chromosomeLength;
    }


    protected Individual createRandomIndividual(int seed) {
        ArrayList<IGene> chromosome = this.generateGenes(chromosomeLength,seed);
        return new Individual(chromosome);
    }

}
