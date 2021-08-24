package graph.questions;

public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public boolean isBST() {
        if(left != null) {
            if(data < left.data || !left.isBST()) {
                return false;
            }
        }
        if(right != null) {
            if(data >= right.data || !right.isBST()) {
                return false;
            }
        }
        return true;
    }

    public int height() {
        int leftHeight = left != null ? left.height() : 0;
        int rightHeight = right != null ? right.height() : 0;
        return 1 + Math.max(leftHeight, rightHeight);

    }

    public static TreeNode createMinimalBST(int[] array) {
        // TODO
        return createMinimalBST(array, 0, array.length - 1);
    }

    private void setLeftNode(TreeNode node) {
        this.left = node;
        if(node != null) {
            node.parent = this;
        }
    }

    private void setRightNode(TreeNode node) {
        this.right = node;
        if(node != null) {
            node.parent = this;
        }
    }

    public static TreeNode createMinimalBST(int[] array, int start, int end) {
        if(end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(array[mid]);
        node.setLeftNode(createMinimalBST(array, start, mid - 1));
        node.setRightNode(createMinimalBST(array, mid + 1, end));
        return node;
    }
}
