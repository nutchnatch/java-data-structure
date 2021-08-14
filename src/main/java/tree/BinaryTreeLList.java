package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLList {

    public static void main(String[] args) {
        BinaryTreeLList binaryTree = new BinaryTreeLList();
        BinaryNode n1 = new BinaryNode();
        n1.value = "N1";
        BinaryNode n2 = new BinaryNode();
        n2.value = "N2";
        BinaryNode n3 = new BinaryNode();
        n3.value = "N3";
        BinaryNode n4 = new BinaryNode();
        n4.value = "N4";
        BinaryNode n5 = new BinaryNode();
        n5.value = "N5";
        BinaryNode n6 = new BinaryNode();
        n6.value = "N6";
        BinaryNode n7 = new BinaryNode();
        n7.value = "N7";
        BinaryNode n8 = new BinaryNode();
        n8.value = "N8";
        BinaryNode n9 = new BinaryNode();
        n9.value = "N9";

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n8;
        n4.right = n9;
        n3.left = n6;
        n3.right = n7;

        binaryTree.root = n1;

        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        binaryTree.postOrder(binaryTree.root);
        System.out.println();
        binaryTree.levelOrder();
        System.out.println();
        binaryTree.search("N9");
        binaryTree.search("N10");
    }

    BinaryNode root;

    public BinaryTreeLList() {
        root = null;
    }

    // PreOrder traversal
    void preOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // InOrder traversal
    void inOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    void postOrder(BinaryNode node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Level order
    void levelOrder() {
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

    void search(String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            if(node.value.equals(value)) {
                System.out.println("The value-" + value + " is found in the tree");
                return;
            } else {
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        System.out.println("The value-" + value + " is not found in the tree");
    }

    // insert node
    void insert(String value) {
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;
        if(root == null) {
            root = newNode;
            System.out.println("Inserted new node at Root");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            if(node.left == null) {
                node.left = newNode;
                System.out.println("Inserted successfully");
                break;
            } else if(node.right == null) {
                node.right = newNode;
                System.out.println("Inserted successfully");
                break;
            } else {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode node = null;
        while(!queue.isEmpty()) {
            node = queue.remove();
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return node;
    }

    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode previousNode = null;
        BinaryNode node = null;
        while(!queue.isEmpty()) {
            previousNode = node;
            node = queue.remove();
            if(node.left == null) {
                previousNode.right = null;
                return;
            } else if(node.right == null) {
                node.left = null;
                return;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    // delete given node
    public void delete(String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            if(node.value.equals(value)) {
                BinaryNode deepestNode = getDeepestNode();
                deleteDeepestNode();
                node.value = deepestNode.value;
                System.out.println("Node is deleted");
                return;
            } else {
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        System.out.println("The node does not exist in this BT.");
    }

    public void deleteTree() {
        root = null;
        System.out.println("Tree is deleted");
    }
}
