package GP.Tree;

import java.util.ArrayList;

public interface INode {
    Double evaluate();
    ITree copy();
    ArrayList<INode> serialize();
}
