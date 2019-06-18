package TreesAndGraphs;
import StacksAndQueues.QueueUsingLinkedList;

import java.util.ArrayList;
import java.util.List;

public class TreeDepth {
    public static void main(String[] args){
        BST tree = new BST(20, true, true);
        Node root  = tree.getBST();
        TreeDepthImpl impl = new TreeDepthImpl();
        impl.findDepth(root);
    }
}

class TreeDepthImpl{
    public void findDepth(Node root){
        QueueUsingLinkedList<Node> queue = new QueueUsingLinkedList();
        queue.enqueue(root);
        List<Node> level1 = new ArrayList<>();
        List<Node> level2 = new ArrayList<>();
        level1.add(root);
        List<List<Node>> depths = new ArrayList<>();
        depths.add(level1);
        int distanceFromRoot = -1;
        while(!queue.isEmpty()){
            Node node = queue.dequeue();
            level1.remove(node);
            node.color = Color.black;
            node.distanceFromRoot = distanceFromRoot++;

            if(node.left != null && node.left.color == Color.white){
                node.left.color = Color.grey;
                queue.enqueue(node.left);
                level2.add(node.left);
            }
            if(node.right != null && node.right.color == Color.white){
                node.right.color = Color.grey;
                queue.enqueue(node.right);
                level2.add(node.right);
            }
            if(level1.isEmpty()){
                level1 = level2;
                if(level2.size() > 0){
                    depths.add(level2);
                }
                level2 = new ArrayList<>();
            }
        }
        System.out.println(depths.size());
    }
}