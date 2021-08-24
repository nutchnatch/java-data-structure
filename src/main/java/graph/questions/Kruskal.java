package graph.questions;

import java.util.*;

import java.util.ArrayList;

public class Kruskal {

    private List<WeightedNode> nodeList = new ArrayList<WeightedNode>();
    private List<UndirectedEdge> edgeList = new ArrayList<>();

    public Kruskal(int first, int second, int weight) {
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(first), nodeList.get(second), weight);
        WeightedNode firstNode = edge.first;
        WeightedNode secondNode = edge.second;
        firstNode.neighbors.add(secondNode);
        secondNode.neighbors.add(firstNode);
        firstNode.map.put(firstNode, weight);
        secondNode.map.put(secondNode, weight);
        edgeList.add(edge);
    }

    void kruskal() {
        DisjoinSet.makeSet(nodeList);
        Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
            @Override
            public int compare(UndirectedEdge o1, UndirectedEdge o2) {
                return o1.weight - o2.weight;
            }
        };
        Collections.sort(edgeList, comparator);
        int cost = 0;
        for(UndirectedEdge edge: edgeList) {
            WeightedNode first = edge.first;
            WeightedNode second = edge.second;
            if(!DisjoinSet.findSet(first).equals(DisjoinSet.findSet(second))) {
                DisjoinSet.union(first, second);
                cost += edge.weight;

            }
        }
    }
}
