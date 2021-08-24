package graph.questions;

import java.util.*;

public class DisjoinSet {

    private List<WeightedNode> nodeList = new ArrayList<>();

    public static void makeSet(List<WeightedNode> nodeList) {
        for (WeightedNode node: nodeList) {
            DisjoinSet set = new DisjoinSet();
            set.nodeList.add(node);
            node.set = set;
        }
    }

    public static DisjoinSet findSet(WeightedNode node) {
        return node.set;
    }

    public static DisjoinSet union(WeightedNode node1, WeightedNode node2) {
        if(node1.set.equals(node2.set)) {
            return null;
        } else {
            DisjoinSet disjoinSet1 = node1.set;
            DisjoinSet disjoinSet2 = node2.set;
            if(disjoinSet1.nodeList.size() > disjoinSet2.nodeList.size()) {
                for(WeightedNode node: disjoinSet2.nodeList) {
                    node.set = disjoinSet1;
                    disjoinSet1.nodeList.add(node);
                }
                return disjoinSet1;
            } else {
                for(WeightedNode node: disjoinSet1.nodeList) {
                    node.set = disjoinSet2;
                    disjoinSet2.nodeList.add(node);
                }
                return disjoinSet2;
            }

        }
    }
}
