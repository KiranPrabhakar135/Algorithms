package TreesAndGraphs;
import java.util.LinkedList;
enum Color{
    white(0),
    grey(1),
    black(2);

    private int value;
    Color(int value)
    {
        this.value = value;
    }
    private int getValue(){
        return this.value;
    }
}

public class Node {
    int value;
    Node left;
    Node right;
    Node parent;
    boolean isVisited;
    Color color;
    int distanceFromRoot;
}
