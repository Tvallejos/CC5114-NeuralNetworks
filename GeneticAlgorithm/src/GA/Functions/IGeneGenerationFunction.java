package GA.Functions;

import GA.Allele;
import GA.Genes.IGene;
import GA.IIndividual;

import java.util.ArrayList;

public interface IGeneGenerationFunction {
    IGene generateGene();

    ArrayList<IGene> generateGenes(int numberOfGenes);

    ArrayList<IIndividual> initializePopulation(int populationSize);

    Allele getAlleleValues();

    int getChomosomeLength();

    ArrayList<IIndividual> initializePopulation(int populationSize, int seed);
}
