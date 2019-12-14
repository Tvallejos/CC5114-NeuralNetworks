package GP.Tree;

import java.util.ArrayList;
import java.util.HashMap;

public interface INode {
    Double evaluate(HashMap<String, Double> env);

    INode copy(IBinaryNode father);

    ArrayList<INode> serialize(ArrayList<INode> Acc);

    IBinaryNode getFather();

    void setFather(IBinaryNode father);

    int getDepth();

    ArrayList<INode> checkRepTerminals(ArrayList<INode> Acc);
}
