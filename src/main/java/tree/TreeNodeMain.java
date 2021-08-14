package tree;

public class TreeNodeMain {

    public static void main(String[] args) {
        BinaryTreeLList binaryTree = new BinaryTreeLList();
        binaryTree.insert("N1");
        binaryTree.insert("N2");
        binaryTree.insert("N3");
        binaryTree.insert("N4");
        binaryTree.insert("N5");
        binaryTree.insert("N6");
        binaryTree.levelOrder();
        System.out.println();
        final String deepestNode = binaryTree.getDeepestNode().value;
        System.out.println("Deepest Node -> " + deepestNode);
//        binaryTree.deleteDeepestNode();
        binaryTree.delete("N3");
        binaryTree.levelOrder();
        System.out.println();
        binaryTree.deleteTree();
    }
}
