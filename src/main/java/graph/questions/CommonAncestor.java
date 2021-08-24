package graph.questions;

public class CommonAncestor {

    public static TreeNode commonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            return null;
        }

        TreeNode parentP = p.parent;
        while(parentP != null) {
            TreeNode parentQ = q.parent;
            while(parentQ != null) {
                if(parentP == parentQ) {
                    return parentP;
                }
                parentQ = parentQ.parent;
            }
            parentP = parentP.parent;
        }
        return null;
    }
}
