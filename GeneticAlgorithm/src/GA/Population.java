package GA;

import GA.Functions.IGeneGenerationFunction;

import java.util.ArrayList;

public class Population {
    private ArrayList<IIndividual> individuals;
    private IGeneGenerationFunction geneGenerationFunction;

    public Population(IGeneGenerationFunction geneGenerationFunction, int populationSize) {
        this.geneGenerationFunction = geneGenerationFunction;
        individuals = geneGenerationFunction.initializePopulation(populationSize);
    }

    public Allele getAlleleValues() {
        return geneGenerationFunction.getAlleleValues();
    }

    public int getChromosomeLength() {
        return geneGenerationFunction.getChomosomeLength();
    }

    public int getPopulationSize() {
        return individuals.size();
    }

    public ArrayList<IIndividual> getIndividuals() {
        return individuals;
    }


    public void setIndividuals(ArrayList<IIndividual> selectedIndividuals) {
        individuals = selectedIndividuals;
    }
}
