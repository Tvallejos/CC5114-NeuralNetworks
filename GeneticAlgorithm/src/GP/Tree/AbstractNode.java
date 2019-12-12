package GP.Tree;

public abstract class AbstractNode implements INode {

    @Override
    public boolean equals(Object o) {
        if (o != null) {
            return o.getClass() == this.getClass();
        }

        return false;
    }
}
