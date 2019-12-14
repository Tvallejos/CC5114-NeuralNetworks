package GA.Functions;

import GA.Allele;
import GA.Functions.AbstractGeneGenerationFunction;
import GA.Genes.IGene;
import GA.Genes.NodeGene;
import GA.IIndividual;
import GA.Individual;
import GP.Tree.IBinaryNode;
import GP.Tree.INode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreeGenerator extends AbstractGeneGenerationFunction {
    private ArrayList<IBinaryNode> innerNodes;
    private ArrayList<INode> terminalNodes;
    private int depth;
    private Double prob;

    public TreeGenerator(ArrayList<IBinaryNode> innerNodes, ArrayList<INode> terminalNodes, int depth, Double prob) {
        this.innerNodes = innerNodes;
        this.terminalNodes = terminalNodes;
        this.depth = depth;
        this.prob = prob;
    }

    public TreeGenerator(ArrayList<IBinaryNode> innerNodes, ArrayList<INode> terminalNodes, int depth) {
        this(innerNodes, terminalNodes, depth, new Random().nextDouble());
    }

    @Override
    public IGene generateGene() {
        return NodeToGene(create_rec_tree(new Random().nextInt(depth), null));
    }

    private IGene NodeToGene(INode rec_tree) {
        return new NodeGene(rec_tree);
    }


    private IBinaryNode getRandomFunction(ArrayList<IBinaryNode> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    private INode create_rec_tree(int aDepth, IBinaryNode father) {

        // si `depth` es mayor a 0, nos toca crear un sub-arbol
        if (aDepth > 0) {
            //si estamos en la prob de terminar entonces retornamos un terminal
            if (new Random().nextDouble() < prob) {
                return getRandomTerminal(terminalNodes).copy(father);
            } else {
                //si no escogemos un funcion aleatoriamente
                IBinaryNode choosenFunc = getRandomFunction(innerNodes);
                INode left = create_rec_tree(aDepth - 1, choosenFunc);
                INode right = create_rec_tree(aDepth - 1, choosenFunc);
                left.setFather(choosenFunc);
                right.setFather(choosenFunc);
                choosenFunc.setLeft(left);
                choosenFunc.setRight(right);
                return choosenFunc.copy(null);
            }

        } else {
            return getRandomTerminal(terminalNodes).copy(father);
        }
    }

    private INode getRandomTerminal(ArrayList<INode> terminalNodes) {
        Random rand = new Random();
        return terminalNodes.get(rand.nextInt(terminalNodes.size()));
    }

    @Override
    public ArrayList<IGene> generateGenes(int numberOfGenes) {
        ArrayList<IGene> genes = new ArrayList<>();
        for (int i = 0; i < numberOfGenes; i++) {
            genes.add(generateGene());
        }
        return genes;
    }

    @Override
    public String individualToString(IIndividual ind) {
        return ind.getGenes().get(0).getNode().toString();
    }

    @Override
    public Allele getAlleleValues() {
        return null;
    }

    @Override
    public int getChomosomeLength() {
        return 1;
    }


    @Override
    protected IIndividual createRandomIndividual(int seed) {
        return new Individual(new ArrayList<>(List.of(generateGene())));
    }
}
