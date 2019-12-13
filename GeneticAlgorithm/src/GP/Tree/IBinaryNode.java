package GP.Tree;

public interface IBinaryNode extends INode {
    void setLeft(INode left);
    void setRight(INode right);
    INode getLeft();
    INode getRight();
}
