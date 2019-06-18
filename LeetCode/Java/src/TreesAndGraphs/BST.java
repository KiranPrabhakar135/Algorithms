package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BST {
    private int count;
    private boolean assignColor;
    private boolean constructAdjacencyList;
    private HashMap<Node, List<Node>> adjacencyList;
    public BST(int numberOfNodes, boolean assignColor, boolean constructAdjacencyList){
        this.count = numberOfNodes;
        this.assignColor = assignColor;
        this.constructAdjacencyList = constructAdjacencyList;
        if(constructAdjacencyList){
            adjacencyList = new HashMap<>();
        }
    }
    public BST(int numberOfNodes){
        this(numberOfNodes, false, false);
    }
    public Node getBST(){
        int[] nodeValues = new int[count];
        nodeValues[0] = (int)(Math.random()*100);
        for (int i = 1; i < count; i++) {
            nodeValues[i] = nodeValues[i-1] + i;
        }
        return getBalancedTree(nodeValues);
    }

    public List<Node> getAdjacencyList(Node node){
        return adjacencyList.get(node);
    }

    private Node getBalancedTree(int[] nodeValues){
        if(nodeValues.length == 0 ){
            return  null;
        }
        int midPoint = nodeValues.length / 2;
        Node root = new Node();
        root.value = nodeValues[midPoint];
        root.left = getBalancedTree(getSubArray(nodeValues, 0, midPoint));
        root.right = getBalancedTree(getSubArray(nodeValues, midPoint+1, nodeValues.length));
        if(assignColor){
            root.color = Color.white;
        }
        if(constructAdjacencyList){
            List<Node> adjacentNodes = new ArrayList<>();
            adjacentNodes.add(root.left);
            adjacentNodes.add(root.right);
            adjacencyList.putIfAbsent(root, adjacentNodes);
        }
        return root;
    }

    private int[] getSubArray(int[] array, int startIndex, int endIndex ){
        int arrayLength = endIndex-startIndex;
        int[] newArray = new int[arrayLength];
        if(newArray.length == 0){
            return newArray;
        }
        int j = 0;
        for (int i = startIndex; i < endIndex; i++) {
            newArray[j] = array[i];
            j++;
        }
        return newArray;
    }
}
