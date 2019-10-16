package GA.Functions;

import GA.Individual;

// TODO IFitness documentation

public interface IFitnessFunction {
    int run(Individual i);
    boolean solutionFound(int fitness);
}
