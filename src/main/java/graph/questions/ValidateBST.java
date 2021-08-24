package graph.questions;

public class ValidateBST {
    private static Integer lastPrinted = null;

    public static boolean checkBST(TreeNode node) {
        return checkBST(node, true);
    }

    public static boolean checkBST(TreeNode node, boolean isLeft) {
        if(node == null) {
            return true;
        }

        if(!checkBST(node.left, true)) {
            return false;
        }

        if(lastPrinted != null) {
            if(isLeft) {
                if(node.data < lastPrinted) {
                    return false;
                }
            } else {
                if(node.data <= lastPrinted) {
                    return false;
                }
            }
        }

        lastPrinted = node.data;
        if(!checkBST(node.right, false)) {
            return false;
        }
        return true;
    }
}
