package graph;

import java.util.List;
import java.util.ArrayList;

public class Graph {

    public static void main(String[] args) {
        List<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        Graph graph = new Graph(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(1, 4);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(4, 3);
        System.out.println(graph.toString());
    }

    List<GraphNode> nodeList = new ArrayList<>();
    int[][] adjacencyMatrix;

    public Graph(List<GraphNode> nodeList) {
        this.nodeList = nodeList;
        this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for(int i = 0; i < nodeList.size(); i ++) {
            s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for(int i = 0; i < nodeList.size(); i ++) {
            s.append(nodeList.get(i).name + ": ");
            for(int j: adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
