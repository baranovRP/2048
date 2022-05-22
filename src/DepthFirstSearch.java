import java.util.ArrayList;
import java.util.List;

class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
        this.name = name;
    }

    // O(v + e) time | O(v) space
    public List<String> depthFirstSearch(List<String> array) {
        array.add(this.name);
        for (Node child : children) {
            child.depthFirstSearch(array);
        }
        return array;
    }

    public Node addChild(String name) {
        Node child = new Node(name);
        children.add(child);
        return this;
    }
}

public class DepthFirstSearch {


}
