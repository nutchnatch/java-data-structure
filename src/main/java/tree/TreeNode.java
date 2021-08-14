package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNode {

    public static void main(String[] args) {
        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hotDrink = new TreeNode("Hot");
        TreeNode coldDrink = new TreeNode("Cold");

        TreeNode tea = new TreeNode("Tea");
        TreeNode coffee = new TreeNode("Coffee");
        TreeNode wine = new TreeNode("Wine");
        TreeNode beer = new TreeNode("beer");

        drinks.addChild(hotDrink);
        drinks.addChild(coldDrink);

        hotDrink.addChild(tea);
        hotDrink.addChild(coffee);

        coldDrink.addChild(wine);
        coldDrink.addChild(beer);

        System.out.println(drinks.print(0));
    }


    String data;
    List<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }

    public void addChild(TreeNode treeNode) {
        this.children.add(treeNode);
    }

    public String print(int level) {
        String ret;
        ret = String.join("", Collections.nCopies(level, "  ")) + data + "\n";
        for(TreeNode node : children) {
            ret += node.print(level + 1);
        }
        return ret;
    }
}
