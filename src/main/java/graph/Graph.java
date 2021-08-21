package graph;

import java.util.*;

public class Graph {

    public static void main(String[] args) {
        List<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));
        nodeList.add(new GraphNode("H", 7));
//        Graph graph = new Graph(nodeList);
//        graph.addUndirectedEdge(0, 1);
//        graph.addUndirectedEdge(0, 2);
//        graph.addUndirectedEdge(0, 3);
//        graph.addUndirectedEdge(1, 4);
//        graph.addUndirectedEdge(2, 3);
//        graph.addUndirectedEdge(4, 3);
//        System.out.println(graph.toString());
//        graph.bfs();
//        graph.dfs();

//        System.out.println();
//        System.out.println("=====================");

//        Graph graph2 = new Graph(nodeList);
//        graph2.addDirectedEdges(0,2);
//        graph2.addDirectedEdges(2,4);
//        graph2.addDirectedEdges(4,7);
//        graph2.addDirectedEdges(4,5);
//        graph2.addDirectedEdges(5,6);
//        graph2.addDirectedEdges(1,2);
//        graph2.addDirectedEdges(1,3);
//        graph2.addDirectedEdges(3,5);
//        System.out.println(graph2.toString());
//        graph2.topologicalSort();

        // SSSPP
        Graph graph = new Graph(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(1, 6);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(3, 5);
        graph.addUndirectedEdge(4, 5);
        graph.addUndirectedEdge(5, 6);
        System.out.println(graph.toString());
        graph.bfsForSSSPP(nodeList.get(0));
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

    public List<GraphNode> getNeighbors(GraphNode node) {
        List<GraphNode> neighbors = new ArrayList<>();
        int nodeIndex = node.index;
        for(int i = 0; i < adjacencyMatrix.length; i ++) {
            if(adjacencyMatrix[nodeIndex][i] == 1) {
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }

    void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            List<GraphNode> neighbors = getNeighbors(currentNode);
            for(GraphNode neighbor: neighbors) {
                if(!neighbor.isVisited) {
                    neighbor.isVisited = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public void bfs() {
        System.out.println("BFS");
        for(GraphNode node: nodeList) {
            if(!node.isVisited) {
                bfsVisit(node);
            }
        }
    }

    void dfsVisit(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for (GraphNode neighbor: getNeighbors(currentNode)) {
                if(!neighbor.isVisited) {
                    neighbor.isVisited = true;
                    stack.push(neighbor);
                }
            }
        }
    }

    void dfs() {
        System.out.println("DFS");
        for(GraphNode node: nodeList) {
            if(!node.isVisited) {
                dfsVisit(node);
            }
        }
    }

    public void addDirectedEdges(int i, int j) {
        adjacencyMatrix[i][j] = 1;
    }

    void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        for(GraphNode neighbor: getNeighbors(node)) {
            if(!neighbor.isVisited) {
                topologicalVisit(neighbor, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node: nodeList) {
            if(!node.isVisited) {
                topologicalVisit(node, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
    }

    public static void pathPrint(GraphNode node) {
        if(node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    public void bfsForSSSPP(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            System.out.print("Printing path for node " + currentNode.name + ": ");
            pathPrint(currentNode);
            System.out.println();
            for(GraphNode neighbor: getNeighbors(currentNode)) {
                if(!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent = currentNode;
                }
            }
        }
    }
}
