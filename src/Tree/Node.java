package Tree;

public class Node {
    public int value;
    public Node leftNode;
    public Node rightNode;

    public Node(int value) {
        this.value = value;
        this.rightNode = null;
        this.leftNode = null;
    }
}
