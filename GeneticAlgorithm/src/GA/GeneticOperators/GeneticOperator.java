package GA.GeneticOperators;

import GA.Allele;
import GA.Genes.IGene;
import GA.Genes.StringGene;
import GA.IIndividual;
import GA.Individual;

import java.util.ArrayList;
import java.util.Random;

public class GeneticOperator implements IGeneticOperator {

    private Allele alleleValues;
    private Double mutationRate;

    public GeneticOperator(Double mutationRate, Allele alleleValues){
        this.mutationRate = mutationRate;
        this.alleleValues = alleleValues;
    }

    @Override
    public IIndividual crossOver(IIndividual ind1, IIndividual ind2) {
        assert(ind1.getGenesSize()==ind2.getGenesSize());
        Random r = new Random();
        int randomInt = r.nextInt(ind1.getGenesSize());
        ArrayList<IGene> crossOverGenes = new ArrayList<>();
        ArrayList<IGene> ind1Genes = ind1.getGenes();
        ArrayList<IGene> ind2Genes = ind2.getGenes();
        // fist randomInt genes
        for (int i = 0; i < randomInt ; i++) {
            crossOverGenes.add(ind1Genes.get(i));
        }
        // last size-randomInt genes
        for (int i = randomInt; i < ind1.getGenesSize() ; i++) {
            crossOverGenes.add(ind2Genes.get(i));
        }

        return new Individual(crossOverGenes);
    }

    @Override
    public IIndividual mutation(IIndividual individual) {
        Random r = new Random();
        int randomInt = r.nextInt(individual.getGenesSize());
        Double prob = r.nextDouble();
        if(prob<mutationRate){
            IGene mutatedGene = createRandomGene();
            individual = createMutatedIndividual(randomInt,mutatedGene,individual);
        }
        return individual;
    }

    private IIndividual createMutatedIndividual(int geneIndex, IGene mutatedGene,IIndividual individual) {
        ArrayList<IGene> newGenes = individual.getGenes();
        newGenes.set(geneIndex,mutatedGene);
        return new Individual(newGenes);
    }

    private IGene createRandomGene() {
        Random r = new Random();
        int randomValue = r.nextInt(alleleValues.getSize());
        return new StringGene(alleleValues.get(randomValue));
    }
}
