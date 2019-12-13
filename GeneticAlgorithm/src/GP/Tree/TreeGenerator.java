package GP.Tree;

import GA.Allele;
import GA.Functions.IGeneGenerationFunction;
import GA.Genes.IGene;
import GA.Genes.NodeGene;
import GA.IIndividual;

import java.util.ArrayList;
import java.util.Random;

//TODO fill IGeneGenerationFunction methods on TreeGenerator

public class TreeGenerator implements IGeneGenerationFunction {
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
    public String individualToString(IIndividual ind) {
        return null;
    }


    @Override
    public IGene generateGene() {
        return NodeToGene(create_rec_tree(depth));
    }

    private IGene NodeToGene(INode rec_tree) {
        return new NodeGene(rec_tree);
    }


    public IBinaryNode getRandomFunction(ArrayList<IBinaryNode> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    private INode create_rec_tree(int aDepth) {

        // si `depth` es mayor a 0, nos toca crear un sub-arbol
        if (aDepth > 0) {
            //si estamos en la prob de terminar entonces retornamos un terminal
            if (new Random().nextDouble() < prob) {
                return getRandomTerminal(terminalNodes).copy();
            } else {
                //si no escogemos un funcion aleatoriamente
                IBinaryNode choosenFunc = getRandomFunction(innerNodes);
                INode left = create_rec_tree(aDepth - 1);
                INode right = create_rec_tree(aDepth - 1);
                choosenFunc.setLeft(left);
                choosenFunc.setRight(right);
                return choosenFunc.copy();
            }

        } else {
            return getRandomTerminal(terminalNodes).copy();
        }
    }

    private INode getRandomTerminal(ArrayList<INode> terminalNodes) {
        Random rand = new Random();
        return terminalNodes.get(rand.nextInt(terminalNodes.size()));
    }

    @Override
    public ArrayList<IGene> generateGenes(int numberOfGenes) {
        return null;
    }

    @Override
    public ArrayList<IIndividual> initializePopulation(int populationSize) {
        return null;
    }

    @Override
    public Allele getAlleleValues() {
        return null;
    }

    @Override
    public int getChomosomeLength() {
        return 0;
    }

    @Override
    public ArrayList<IIndividual> initializePopulation(int populationSize, int seed) {
        return null;
    }
}
