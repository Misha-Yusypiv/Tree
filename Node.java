public class Node {
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Node(Node node) {
        this.data = node.data;
        this.leftChild = node.leftChild;
        this.rightChild = node.rightChild;
    }

    public Node(int data, Node leftChild, Node rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void delete() {
        this.data = 0;
        this.leftChild = null;
        this.rightChild = null;
    }
}
