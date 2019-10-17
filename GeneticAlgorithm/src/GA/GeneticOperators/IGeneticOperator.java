package GA.GeneticOperators;

import GA.IIndividual;

import java.util.ArrayList;

public interface IGeneticOperator {

    ArrayList<IIndividual> reproduce(ArrayList<IIndividual> individuals, int howManyNew);

    IIndividual crossOver(IIndividual ind1, IIndividual ind2);

    IIndividual mutation(IIndividual individual);

}
