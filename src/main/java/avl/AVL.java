package avl;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {

    public static void main(String[] args) {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(10);
        avl.insert(15);
        avl.insert(20);
        avl.levelOrder();
        System.out.println();
        avl.delete(5);
        avl.levelOrder();
        avl.deleteTree();
    }

    BinaryNode root;

    AVL() {
        root = null;
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

    // get height
    private int getHeight(BinaryNode node) {
        if(node == null) {
            return 0;
        } else {
           return node.height;
        }
    }

    // rotate right
    private BinaryNode rotateRight(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // rotate left
    private BinaryNode rotateLeft(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // get balanced
    private int getBalance(BinaryNode node) {
        if(node == null) {
            return 0;
        } else {
            return getHeight(node.left) - getHeight(node.right);
        }
    }

    // insert
    private BinaryNode insert(BinaryNode node, int value) {
        if(node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            newNode.height = 1;
            return newNode;
        } else if(value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);
        if(balance > 1 && value < node.left.value) {
            return rotateRight(node);
        }

        if(balance > 1 && value > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if(balance < -1 && value > node.right.value) {
            return rotateLeft(node);
        }

        if(balance < -1 && value < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    // minimum node
    private static BinaryNode minimumNode(BinaryNode node) {
        if(node.left == null) {
            return node;
        } else {
            return minimumNode(node.left);
        }
    }

    // delete
    private  BinaryNode delete(BinaryNode node, int value) {
        if(node == null) {
            System.out.println("Value " + value + " not found on the tree");
            return node;
        }
        if(value < node.value) {
            node.left = delete(node.left, value);
        } else if(value > node.value) {
            node.right = delete(node.right, value);
        } else {
            if(node.left != null && node.right != null) {
                BinaryNode tmp = node;
                BinaryNode minimumNode = minimumNode(tmp.right);
                node.value = minimumNode.value;
                node.right = delete(node.right, minimumNode.value);
            } else if(node.left != null) {
                node = node.left;
            } else if(node.right != null) {
                node = node.right;
            } else {
                node = null;
            }

            int balance = getBalance(node);
            if(balance > 1 && getBalance(node.left) >= 0) {
                return rotateRight(node);
            } else if(balance > 1 && getBalance(node.left) < 0) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            } else if(balance < -1 && getBalance(node.right) <= 0) {
                return rotateLeft(node);
            } else if(balance < -1 && getBalance(node.right) > 0) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    public void deleteTree() {
        root = null;
        System.out.println("Tree successfully deleted.");
    }
}
