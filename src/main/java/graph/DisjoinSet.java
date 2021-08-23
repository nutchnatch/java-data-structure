package graph;

import java.util.ArrayList;
import java.util.List;

public class DisjoinSet {

    public static void main(String[] args) {
        List<WeightedNode> nodeList = new ArrayList<>();

        DisjoinSet disjoinSet = new DisjoinSet();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        DisjoinSet.makeSet(nodeList);
        WeightedNode firstNode = nodeList.get(0);
        WeightedNode secondNode = nodeList.get(1);
        DisjoinSet output = DisjoinSet.findSet(secondNode);
        output.printAllNodesOfThisSet();

        DisjoinSet.union(firstNode, secondNode);
        output = DisjoinSet.findSet(secondNode);
        output.printAllNodesOfThisSet();
    }

    private List<WeightedNode> nodeList = new ArrayList<>();

    public static void makeSet(List<WeightedNode> nodeList) {
        for(WeightedNode node: nodeList){
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
            DisjoinSet set1 = node1.set;
            DisjoinSet set2 = node2.set;
            if(set1.nodeList.size() > set2.nodeList.size()) {
                List<WeightedNode> nodeSet2 = set2.nodeList;
                for(WeightedNode node: nodeSet2) {
                    node.set = set1;
                    set1.nodeList.add(node);
                }
                return set1;
            } else {
                List<WeightedNode> nodeSet1 = set1.nodeList;
                for(WeightedNode node: nodeSet1) {
                    node.set = set2;
                    set2.nodeList.add(node);
                }
                return set2;
            }
        }
    }

    public void printAllNodesOfThisSet() {
        System.out.println("Print all nodes from the set: ");
        for(WeightedNode node: nodeList){
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
