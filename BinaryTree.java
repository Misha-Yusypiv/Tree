public class BinaryTree {
    Node root;
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.data == key) {
                return current;
            } else if (current.data > key) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        return null;
    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.leftChild);
            System.out.print(node.data + " ");
            inOrderTraversal(node.rightChild);
        }
    }

}
