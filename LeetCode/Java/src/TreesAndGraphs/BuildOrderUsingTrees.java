package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuildOrderUsingTrees {
    public static void main(String[] args){
        HashMap<Node, List<Node>> dependencies = new HashMap<>();
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();

        dependencies.put(a, new ArrayList<Node>());
    }
}

class BuildOrderUsingTreesImpl{
    public Node constructTree(HashMap<Node, List<Node>> dependencies){
        Node root = null;
        for (Node n: dependencies.keySet()
             ) {
            if(n.parent == null){
                root = n;
            }
            for (Node node :
                    dependencies.get(n)) {
                node.parent = n;
            }
        }
        return root;
    }
}