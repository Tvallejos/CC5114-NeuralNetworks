package GP.Tree;

import java.util.ArrayList;

//TODO SERIALIZE IN ALL INODES
public interface INode {
    Double evaluate();

    INode copy();

    ArrayList<INode> serialize();
}
