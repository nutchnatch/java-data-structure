package binary.search.tree;
import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(70);
        binarySearchTree.insert(50);
        binarySearchTree.insert(90);
        binarySearchTree.insert(30);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.insert(100);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);

        binarySearchTree.preOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.postOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.levelOrder();
        System.out.println();
        binarySearchTree.search(binarySearchTree.root, 40);
        System.out.println();
        binarySearchTree.delete(binarySearchTree.root, 90);
        binarySearchTree.levelOrder();
        System.out.println();
        binarySearchTree.deleteTree();
    }
    BinaryNode root;
    public BinarySearchTree() {
        root = null;
    }

    public BinaryNode insert(BinaryNode currentNode, int value) {
        if(currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            System.out.println("A value successfully inserted.");
            return newNode;
        } else if(value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public void preOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            System.out.print(node.value + " ");
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public BinaryNode search (BinaryNode node, int value) {
        if(node == null) {
            System.out.println("Value: " + value + " not found in BST");
            return null;
        } else if(value == node.value) {
            System.out.println("Value: " + value + " found in BST");
            return node;
        } else if(value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    private static BinaryNode minimumNode(BinaryNode node) {
        if(node.left == null) {
            return node;
        } else {
            return minimumNode(node.left);
        }
    }

    public BinaryNode delete(BinaryNode node, int value) {
        if(node == null) {
            System.out.println("Value:" + value + " not found in the tree");
            return null;
        }
        if(value < node.value) {
            node.left = delete(node.left, value);
        } else if(value > node.value) {
            node.right = delete(node.right, value);
        } else {
            if(node.left != null && node.right != null) {
                BinaryNode tmp = node;
                BinaryNode minimumNodeForRight = minimumNode(tmp.right);
                node.value = minimumNodeForRight.value;
                node.right = delete(node.right, minimumNodeForRight.value);
            } else if(node.left != null) {
                node = node.left;
            } else if(root.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }
        return node;
    }

    public void deleteTree() {
        root = null;
        System.out.println("Tree deleted successfully");
    }
}
