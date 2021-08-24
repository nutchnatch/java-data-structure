package graph.questions;

public class CheckBalanced {
    public static boolean isBalanced(TreeNode node) {
        return validateHeight(node) != Integer.MIN_VALUE;
    }

    public static int validateHeight(TreeNode node) {
        if(node == null) {
            return -1;
        }

        int leftHeight = validateHeight(node.left);
        if(leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = validateHeight(node.right);
        if(rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int diff = leftHeight - rightHeight;
        if(Math.abs(diff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
