package graph.questions;

import java.util.List;
import java.util.ArrayList;

public class GraphNode {

    public String name;
    public int index;
    public boolean isVisited;
    public GraphNode parent;
    public List<GraphNode> neighbors = new ArrayList<>();

    public GraphNode(String nodeName, int nodeIndex) {
        this.name = nodeName;
        this.index = nodeIndex;
    }
}
