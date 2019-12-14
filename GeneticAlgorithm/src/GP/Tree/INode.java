package GP.Tree;

import java.util.ArrayList;

public interface INode {
    Double evaluate();

    INode copy(IBinaryNode father);

    ArrayList<INode> serialize(ArrayList<INode> Acc);

    IBinaryNode getFather();

    void setFather(IBinaryNode father);

    int getDepth();

    ArrayList<INode> checkRepTerminals(ArrayList<INode> Acc);
}
