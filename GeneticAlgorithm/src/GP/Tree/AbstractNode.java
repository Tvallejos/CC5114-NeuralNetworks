package GP.Tree;

import java.util.ArrayList;

public abstract class AbstractNode implements INode {
    protected IBinaryNode father;

    public AbstractNode(IBinaryNode father) {
        this.father = father;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null) {
            return o.getClass() == this.getClass();
        }

        return false;
    }

    @Override
    public IBinaryNode getFather() {
        return father;
    }

    @Override
    public void setFather(IBinaryNode father) {
        this.father = father;
    }

    @Override
    public int getDepth() {
        return 1;
    }

    @Override
    public ArrayList<INode> serialize(ArrayList<INode> Acc) {
        Acc.add(this);
        return Acc;
    }

}
