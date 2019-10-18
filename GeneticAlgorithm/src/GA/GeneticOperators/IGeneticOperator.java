package GA.GeneticOperators;

import GA.Functions.IGeneGenerationFunction;
import GA.IIndividual;

import java.util.ArrayList;

public interface IGeneticOperator {

    ArrayList<IIndividual> reproduce(ArrayList<IIndividual> individuals, int howManyNew, IGeneGenerationFunction geneGenerationFunction);

    IIndividual crossOver(IIndividual ind1, IIndividual ind2);

    IIndividual mutation(IIndividual individual, IGeneGenerationFunction geneGenerationFunction);

}
