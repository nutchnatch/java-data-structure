package graph.questions;

public class Successor {
    public static TreeNode inorderSucc(TreeNode node) {
        if(node == null) {
            return null;
        }
        if(node.parent == null || node.right != null) {
            return leftMostNode(node.right);
        } else {
            TreeNode q = node;
            TreeNode parent = node.parent;
            while(parent != null && parent.left != q) {
                q = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private static TreeNode leftMostNode(TreeNode node) {
        if(node == null) {
            return null;
        }
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}
