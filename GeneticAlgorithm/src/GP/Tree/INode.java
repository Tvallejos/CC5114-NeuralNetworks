package GP.Tree;

import java.util.ArrayList;

public interface INode {
    Double evaluate(Double x, Double y);

    ITree copy();

    ArrayList<INode> serialize();
}
