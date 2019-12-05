package GP.Tree;

import GA.Allele;
import GA.Functions.IGeneGenerationFunction;
import GA.Genes.IGene;
import GA.IIndividual;

import java.util.ArrayList;

//TODO fill IGeneGenerationFunction methods on TreeGenerator

//TODO probability to choose not keep expanding and select a terminal node instead
public class TreeGenerator implements IGeneGenerationFunction {
    private ArrayList<INode> innerNodes;
    private ArrayList<INode> terminalNodes;
    private int depth;

    public TreeGenerator(ArrayList<INode> innerNodes, ArrayList<INode> terminalNodes,int depth) {
        this.innerNodes = innerNodes;
        this.terminalNodes = terminalNodes;
        this.depth = depth;
    }

    @Override
    public String individualToString(IIndividual ind) {
        return null;
    }

    @Override
    public IGene generateGene() {
        return null;
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
