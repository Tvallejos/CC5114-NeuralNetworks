package GA.GeneticOperators;

import GA.IIndividual;

public interface IGeneticOperator {

    IIndividual crossOver(IIndividual ind1, IIndividual ind2);

    IIndividual mutation(IIndividual individual);

}
