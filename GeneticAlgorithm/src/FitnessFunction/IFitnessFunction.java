package FitnessFunction;

import GA.Genes.IGene;
import GA.Individual;

import java.util.ArrayList;

// TODO IFitness documentation

public interface IFitnessFunction {
    int run(Individual i);
    boolean solutionFound(int fitness);
}
