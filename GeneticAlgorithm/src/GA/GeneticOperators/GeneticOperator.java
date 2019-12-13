package GA.GeneticOperators;

import GA.Allele;
import GA.Functions.IGeneGenerationFunction;
import GA.Genes.IGene;
import GA.IIndividual;
import GA.Individual;

import java.util.ArrayList;
import java.util.Random;

// TODO test implementation of genetic operations
public class GeneticOperator implements IGeneticOperator {

    protected Double mutationRate;

    public GeneticOperator(Double mutationRate) {
        this.mutationRate = mutationRate;
    }


    public ArrayList<IIndividual> reproduce(ArrayList<IIndividual> individuals, int howManyNew, int seed, IGeneGenerationFunction geneGenerationFunction) {
        ArrayList<IIndividual> reproducedIndividuals = new ArrayList<>();
        for (IIndividual ind : individuals) {
            reproducedIndividuals.add(ind);
        }
        Random r = new Random(seed);
        int selected1, selected2;

        //howManyNew crossOvers
        for (int i = 0; i < howManyNew; i++) {
            selected1 = r.nextInt(individuals.size());
            selected2 = r.nextInt(individuals.size());
            IIndividual crossOverInd = crossOver(individuals.get(selected1), individuals.get(selected2));
            reproducedIndividuals.add(crossOverInd);
        }

        //Try to mutate all the individuals
        for (int i = 0; i < reproducedIndividuals.size(); i++) {
            IIndividual mutatedInd = mutation(reproducedIndividuals.get(i), geneGenerationFunction);
            reproducedIndividuals.set(i, mutatedInd);
        }
        return reproducedIndividuals;
    }

    @Override
    public ArrayList<IIndividual> reproduce(ArrayList<IIndividual> individuals, int howManyNew, IGeneGenerationFunction geneGenerationFunction) {
        return reproduce(individuals, howManyNew, new Random().nextInt(), geneGenerationFunction);
    }

    @Override
    public IIndividual crossOver(IIndividual ind1, IIndividual ind2) {
        return crossOver(ind1, ind2, new Random().nextInt());
    }

    public IIndividual crossOver(IIndividual ind1, IIndividual ind2, int seed) {
        assert (ind1.getGenesSize() == ind2.getGenesSize());
        Random r = new Random(seed);

        int randomInt = r.nextInt(ind1.getGenesSize());
        ArrayList<IGene> crossOverGenes = new ArrayList<>();
        ArrayList<IGene> ind1Genes = ind1.getGenes();
        ArrayList<IGene> ind2Genes = ind2.getGenes();

        // fist randomInt genes
        for (int i = 0; i < randomInt; i++) {
            crossOverGenes.add(ind1Genes.get(i));
        }
        // last size-randomInt genes
        for (int i = randomInt; i < ind1.getGenesSize(); i++) {
            crossOverGenes.add(ind2Genes.get(i));
        }

        return new Individual(crossOverGenes);
    }

    @Override
    public IIndividual mutation(IIndividual individual, IGeneGenerationFunction geneGenerationFunction) {
        return mutation(individual, new Random().nextInt(), geneGenerationFunction);
    }

    public IIndividual mutation(IIndividual individual, int seed, IGeneGenerationFunction geneGenerationFunction) {
        Random r = new Random(seed);
        int randomInt = r.nextInt(individual.getGenesSize());
        Double prob = r.nextDouble();
        if (prob < mutationRate) {
            IGene mutatedGene = geneGenerationFunction.generateGene();
            return createMutatedIndividual(randomInt, mutatedGene, individual);
        }
        return individual;
    }

    protected IIndividual createMutatedIndividual(int geneIndex, IGene mutatedGene, IIndividual individual) {
        ArrayList<IGene> newGenes = individual.getGenes();
        newGenes.set(geneIndex, mutatedGene);
        return new Individual(newGenes);
    }
}
