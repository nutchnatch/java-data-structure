package graph.questions;

import java.util.*;

public class UndirectedEdge {

    public WeightedNode first;
    public WeightedNode second;
    public int weight;
    public List<WeightedNode> neighbors;
    public Map<WeightedNode, Integer> weightMap;

    public UndirectedEdge(WeightedNode first, WeightedNode second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }
}
