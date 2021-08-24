package graph.questions;




import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class WeightedNode {

    public String name;
    public int index;
    public int distance;
    public Map<WeightedNode, Integer> map = new HashMap<>();
    public List<WeightedNode> neighbors = new ArrayList<>();
    public WeightedNode parent;
    public boolean isVisited;
    public DisjoinSet set;


    public WeightedNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
