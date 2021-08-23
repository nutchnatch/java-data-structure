package graph;

import java.util.*;

public class Kruskal {

    public static void main(String[] args) {
        List<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        nodeList.add(new WeightedNode("E", 4));

        Kruskal graph = new Kruskal(nodeList);
        graph.addWeightedUndirectedEdge(0, 1, 5);
        graph.addWeightedUndirectedEdge(0, 2, 13);
        graph.addWeightedUndirectedEdge(0, 4, 15);
        graph.addWeightedUndirectedEdge(1, 2, 10);
        graph.addWeightedUndirectedEdge(1, 3, 8);
        graph.addWeightedUndirectedEdge(2, 3, 6);
        graph.addWeightedUndirectedEdge(2, 4, 20);
        System.out.println("Running Kruskal algo on the graph");
        graph.kruskal();
    }

    private List<WeightedNode> nodeList = new ArrayList<>();
    private List<UndirectedEdge> edgeList = new ArrayList<>();

    public Kruskal(List<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
        WeightedNode first = edge.first;
        WeightedNode second = edge.second;
        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
        edgeList.add(edge);
    }

    void kruskal() {
        DisjoinSet.makeSet(nodeList);
        Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
            @Override
            public int compare(UndirectedEdge o1, UndirectedEdge o2) {
                return o1.weight - o2.weight; // order in an increasing way
            }
        };

        Collections.sort(edgeList, comparator); // sort undirected edge based on their weight
        int cost = 0;
        for(UndirectedEdge edge: edgeList) {
            WeightedNode first = edge.first;
            WeightedNode second = edge.second;
            if(!DisjoinSet.findSet(first).equals(DisjoinSet.findSet(second))) {
                DisjoinSet.union(first, second);
                cost += edge.weight;
                System.out.println("Taken " + edge);
            }
        }

        System.out.println("Total cost of MST: " + cost);
    }
}
