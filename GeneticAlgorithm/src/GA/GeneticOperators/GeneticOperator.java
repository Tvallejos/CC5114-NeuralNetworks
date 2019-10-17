package GA.GeneticOperators;

import GA.Allele;
import GA.Genes.IGene;
import GA.Genes.StringGene;
import GA.IIndividual;
import GA.Individual;

import java.util.ArrayList;
import java.util.Random;

// TODO test implementation of genetic operations
public class GeneticOperator implements IGeneticOperator {

    private Allele alleleValues;
    private Double mutationRate;

    public GeneticOperator(Double mutationRate, Allele alleleValues) {
        this.mutationRate = mutationRate;
        this.alleleValues = alleleValues;
    }


    public ArrayList<IIndividual> reproduce(ArrayList<IIndividual> individuals, int howManyNew, int seed) {
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
            IIndividual mutatedInd = mutation(reproducedIndividuals.get(i));
            reproducedIndividuals.set(i, mutatedInd);
        }
        return reproducedIndividuals;
    }

    @Override
    public ArrayList<IIndividual> reproduce(ArrayList<IIndividual> individuals, int howManyNew) {
        return reproduce(individuals, howManyNew, new Random().nextInt());
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
    public IIndividual mutation(IIndividual individual) {
        return mutation(individual, new Random().nextInt());
    }

    public IIndividual mutation(IIndividual individual, int seed) {
        Random r = new Random(seed);
        int randomInt = r.nextInt(individual.getGenesSize());
        Double prob = r.nextDouble();
        if (prob < mutationRate) {
            IGene mutatedGene = createRandomGene(r.nextInt());
            return createMutatedIndividual(randomInt, mutatedGene, individual);
        }
        return individual;
    }

    private IIndividual createMutatedIndividual(int geneIndex, IGene mutatedGene, IIndividual individual) {
        ArrayList<IGene> newGenes = individual.getGenes();
        newGenes.set(geneIndex, mutatedGene);
        return new Individual(newGenes);
    }

    //private IGene createRandomGene() {
    //    return createRandomGene(new Random().nextInt());
    //}

    private IGene createRandomGene(int seed) {
        return new StringGene(alleleValues.getRandom(seed));
    }
}
