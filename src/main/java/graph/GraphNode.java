package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    public String name;
    public int index;
    public List<GraphNode> neighbors = new ArrayList<>();

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
