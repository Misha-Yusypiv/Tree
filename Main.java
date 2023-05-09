public class Main {
    public static void main(String[] args) {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        root.left = new BinaryNode<>(2);
        root.right = new BinaryNode<>(3);
        root.left.left = new BinaryNode<>(4);
        root.left.right = new BinaryNode<>(5);
        root.right.left = new BinaryNode<>(6);
        root.right.right = new BinaryNode<>(7);

        System.out.println("numbel: " + root.numbel());
        System.out.println("numbl: " + root.numbl());
        System.out.println("height: " + root.height());
        System.out.println("empty: " + root.empty());
        System.out.println("before swap: " + root.left.value + ", " + root.right.value);
        root.swap();
        System.out.println("after swap: " + root.left.value + ", " + root.right.value);
        System.out.println("include 5: " + root.include(5));
        System.out.println("exclude 5");
        root.exclude(5);
        System.out.println("include 5 after exclude: " + root.include(5));
        System.out.println("Find 5: " + root.find(5)); // true
        System.out.println("Find 8: " + root.find(8)); // false
        System.out.println("accumulate sum: " + root.accumulate(0, Integer::sum));
        System.out.print("for_each values:");
        root.for_each(System.out::print);


        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.leftChild = new Node(2);
        binaryTree.root.rightChild = new Node(3);
        binaryTree.root.leftChild.leftChild = new Node(4);
        binaryTree.root.leftChild.rightChild = new Node(5);

        System.out.println("Inorder traversal of binary tree is ");
        binaryTree.inOrderTraversal(binaryTree.root);
        Node node = new Node(5);
        System.out.println("Node data is " + node.data);

        node.delete();
        System.out.println("Node data after delete is " + node.data);
        Node node2 = binaryTree.find(5);
        System.out.println("Node data is " + node2.data);



    }
}

