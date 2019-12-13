package GA.Genes;

import GP.Tree.INode;

public class NodeGene extends AbstractGene {

    private INode node;

    public NodeGene(INode node){
        super(node.toString());
        this.node = node;
    }

    public INode getNode() {
        return node;
    }

}
