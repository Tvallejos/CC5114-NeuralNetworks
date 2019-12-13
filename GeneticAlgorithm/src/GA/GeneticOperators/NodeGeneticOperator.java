package GA.GeneticOperators;


import GA.Functions.IGeneGenerationFunction;
import GA.Genes.IGene;
import GA.Genes.NodeGene;
import GA.IIndividual;
import GA.Individual;
import GP.Tree.INode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NodeGeneticOperator extends GeneticOperator {

    public NodeGeneticOperator(Double mutationRate) {
        super(mutationRate);
    }

    @Override
    public IIndividual crossOver(IIndividual ind1, IIndividual ind2, int seed) {
        assert (ind1.getGenesSize() == ind2.getGenesSize());

        IGene ind1Gene = ind1.getGenes().get(0);
        IGene ind2Gene = ind2.getGenes().get(0);


        INode new_element = ind1Gene.getNode().copy(null);
        INode p1 = chooseRandomSubTree(new_element.serialize(new ArrayList<>()));
        INode p2 = chooseRandomSubTree(ind2Gene.getNode().serialize(new ArrayList<>()));
        p2 = p2.copy(p1.getFather());
        replace(p1, p2);

        return new Individual(new ArrayList<>(List.of(new NodeGene(p1))));
    }

    private void replace(INode p1, INode p2) {
        if (p1 == p1.getFather().getLeft()) {// soy el hijo izquierdo
            p1.getFather().setLeft(p2);
        } else {
            p1.getFather().setRight(p2);
        }
    }

    private INode chooseRandomSubTree(ArrayList<INode> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    @Override
    public IIndividual mutation(IIndividual individual, int seed, IGeneGenerationFunction geneGenerationFunction) {
        Double prob = new Random(seed).nextDouble();
        if (prob < mutationRate) {
            INode new_element = individual.getGenes().get(0).getNode().copy(null);
            INode p1 = chooseRandomSubTree(new_element.serialize(new ArrayList<>()));
            INode p2 = geneGenerationFunction.generateGene().getNode();
            p2.setFather(p1.getFather());
            replace(p1, p2);
            return new Individual(new ArrayList<>(List.of(new NodeGene(new_element))));
        }
        return individual;
    }

}
