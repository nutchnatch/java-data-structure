package graph;

import java.util.*;

public class WeightedGraph   {

    public static void main(String[] args) {
        List<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        nodeList.add(new WeightedNode("E", 4));
        nodeList.add(new WeightedNode("F", 5));
        nodeList.add(new WeightedNode("G", 6));
        nodeList.add(new WeightedNode("H", 7));
        WeightedGraph weightedGraph = new WeightedGraph(nodeList);
        weightedGraph.addWeightedEdge(0, 1, 2);
        weightedGraph.addWeightedEdge(0, 2, 5);
        weightedGraph.addWeightedEdge(1, 2, 6);
        weightedGraph.addWeightedEdge(1, 3, 1);
        weightedGraph.addWeightedEdge(1, 4, 3);
        weightedGraph.addWeightedEdge(2, 5, 8);
        weightedGraph.addWeightedEdge(3, 4, 4);
        weightedGraph.addWeightedEdge(4, 6, 9);
        weightedGraph.addWeightedEdge(5, 6, 7);
//        System.out.println("Printing Dijkstra from source: A");
//        weightedGraph.dijkstra(nodeList.get(0));

        System.out.println("Printing BellmanFord from source: A");
        weightedGraph.bellmanFord(nodeList.get(0));
    }

    private List<WeightedNode> nodeList = new ArrayList<>();

    public WeightedGraph(List<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public static void pathPrint(WeightedNode node) {
        if(node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    void dijkstra(WeightedNode node) {
        Queue<WeightedNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while(!queue.isEmpty()) {
            WeightedNode currentNode = queue.remove();
            for(WeightedNode neighbor: currentNode.neighbors) {
                if(queue.contains(neighbor)) {
                    if(neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                        queue.remove(neighbor); // refresh priority queue
                        queue.add(neighbor);
                    }
                }
            }
        }

        // print path
        for(WeightedNode nodeToCheck: nodeList) {
            System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    public void addWeightedEdge(int i, int j, int d) { // d = cost of edge
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second, d);
    }

    void bellmanFord(WeightedNode sourceNode) {
        sourceNode.distance = 0;
        for(int i = 0; i < nodeList.size(); i ++) {
            for(WeightedNode currentNode: nodeList) {
                for(WeightedNode neighbor: currentNode.neighbors) {
                    if(neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                    }
                }
            }
        }

        // check negative cycles
        System.out.println("checking for negative cycles");
        for(WeightedNode currentNode: nodeList) {
            for(WeightedNode neighbor: currentNode.neighbors) {
                if(neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                    System.out.println("Negative cycle found");
                    System.out.println("Vertex name: " + neighbor.name);
                    System.out.println("Old cost: " + neighbor.distance);
                    int newDistance = currentNode.distance + currentNode.weightMap.get(neighbor);
                    System.out.println("New cost: " + newDistance);
                    return;
                }
            }
        }
        System.out.println("Negative cycles not found");

        // print path
        for(WeightedNode nodeToCheck: nodeList) {
            System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }
}
