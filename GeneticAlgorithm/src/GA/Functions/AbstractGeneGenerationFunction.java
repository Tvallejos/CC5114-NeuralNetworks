package GA.Functions;

import GA.IIndividual;
import GA.Individual;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractGeneGenerationFunction implements IGeneGenerationFunction {
    protected abstract IIndividual createRandomIndividual(int seed);

    @Override
    public ArrayList<IIndividual> initializePopulation(int populationSize, int seed) {
        Random r = new Random(seed);
        ArrayList<IIndividual> individuals = new ArrayList();
        for (int i = 0; i < populationSize; i++) {
            IIndividual newIndividual = createRandomIndividual(r.nextInt());
            individuals.add(newIndividual);
        }
        return individuals;
    }

    @Override
    public ArrayList<IIndividual> initializePopulation(int populationSize) {
        return initializePopulation(new Random().nextInt(), populationSize);
    }
}
