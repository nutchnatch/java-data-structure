package graph.questions;

import java.util.*;


public class GraphRouteBetweenNodes {

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

        GraphRouteBetweenNodes graph = new GraphRouteBetweenNodes(nodeList, "");
    }

    public List<WeightedNode> nodeList = new ArrayList<>();
    public List<GraphNode> graphNodeList = new ArrayList<>();
    private Map<String, GraphNode> graphNodeMap = new HashMap<>();

    public GraphRouteBetweenNodes(List<GraphNode> nodeList, String g) {
        this.graphNodeList = nodeList;
    }

    public GraphRouteBetweenNodes(List<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addNodes(int i, int j,int d) {
        GraphNode first = graphNodeList.get(i);
        GraphNode second = graphNodeList.get(i);
        graphNodeMap.put(first.name, first);
        graphNodeMap.put(second.name, second);
        first.neighbors.add(second);
    }

    public boolean bfsSSSPath(GraphNode firstNode, GraphNode secondNode) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(firstNode);
        while(!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            for(GraphNode neighbor: currentNode.neighbors) {
                if(!neighbor.isVisited) {
                    neighbor.parent = currentNode;
                    neighbor.isVisited = true;
                    if(secondNode == neighbor) {
                        return true;
                    } else {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return false;
    }

    public void addDirectedNodes(int i, int j,int d) {
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(i);
        first.neighbors.add(second);
        first.map.put(second, d);
    }

    public void dijkstra(WeightedNode node) {
        Queue<WeightedNode> queue = new PriorityQueue<>();
        queue.addAll(nodeList);
        while(!queue.isEmpty()) {
            WeightedNode currentNode = queue.remove();
            System.out.println("Node " + currentNode.name);
            for(WeightedNode neighbor: currentNode.neighbors) {
                if(queue.contains(neighbor)) {
                    if(currentNode.distance < currentNode.distance + currentNode.map.get(neighbor)) {
                        currentNode.distance = currentNode.distance + currentNode.map.get(neighbor);
                        neighbor.parent = currentNode;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }

            for(int i = 0; i < nodeList.size(); i ++) {
                WeightedNode fetchedNode = nodeList.get(i);
                System.out.println("Node: " + fetchedNode.name + " Distance: " + fetchedNode.distance + " Path: ");
                printGraph(fetchedNode);
                System.out.println();
            }
        }
    }

    public void dijkstra() {
        for(int i = 0; i < nodeList.size(); i ++) {
            WeightedNode node = nodeList.get(i);
            if(!node.isVisited) {
                dijkstra(node);
            }
        }
    }

    public void printGraph(WeightedNode node) {
        if(node.parent != null) {
            printGraph(node.parent);
        }
        System.out.print(node.name + " ");
    }

    public void printGraph(GraphNode node) {
        if(node.parent != null) {
            printGraph(node.parent);
        }
        System.out.print(node.name + " ");
    }
}
