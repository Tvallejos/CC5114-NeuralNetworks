package GA.Functions;

import GA.IIndividual;

// TODO IFitness documentation

public interface IFitnessFunction {
    int run(IIndividual i);
    boolean solutionFound(int fitness);
}
