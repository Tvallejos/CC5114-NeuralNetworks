package GP.Tree;

import java.util.ArrayList;

public class Tree {
    private INode root;
    private ArrayList<INode> innerNodes;
    private ArrayList<INode> terminalNodes;
    private int depth;

    public Tree(ArrayList<INode> innerNodes, ArrayList<INode> terminalNodes, int depth) {
        this.innerNodes = innerNodes;
        this.terminalNodes = terminalNodes;
        this.depth = depth;

    }
}
