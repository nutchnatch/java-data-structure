package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {

    public static void main(String[] args) {
        List<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        nodeList.add(new WeightedNode("E", 4));

        Prims graph = new Prims(nodeList);
        graph.addWeightedUndirectedEdge(0, 1, 5);
        graph.addWeightedUndirectedEdge(0, 2, 13);
        graph.addWeightedUndirectedEdge(0, 4, 15);
        graph.addWeightedUndirectedEdge(1, 2, 10);
        graph.addWeightedUndirectedEdge(1, 3, 8);
        graph.addWeightedUndirectedEdge(2, 3, 6);
        graph.addWeightedUndirectedEdge(2, 4, 20);
        System.out.println("Running Prims algo on the graph");
        graph.prims(nodeList.get(4));
    }

    private List<WeightedNode> nodeList = new ArrayList<>();

    public Prims(List<WeightedNode> nodeList) {
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
    }

    void prims(WeightedNode node) {
        for(int i = 0; i < nodeList.size(); i ++) {
            nodeList.get(0).distance = Integer.MAX_VALUE;
        }
        node.distance = 0;
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        queue.addAll(nodeList);
        while(!queue.isEmpty()) {
            WeightedNode currentNode = queue.remove();
            for(WeightedNode neighbor: currentNode.neighbors) {
                if(queue.contains(neighbor)) {
                    if(neighbor.distance > currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                        queue.remove(neighbor);
                        queue.add(neighbor); // refresh neighbor in queue
                    }
                }
            }
        }

        int cost = 0;
        for(WeightedNode nodeToCheck: nodeList) {
            System.out.println("Node " + nodeToCheck + ", key " +nodeToCheck.distance + " Parent: "  + nodeToCheck.parent);
            cost = cost + nodeToCheck.distance;
        }
        System.out.println("Total cost of MST: " + cost);
    }
}
