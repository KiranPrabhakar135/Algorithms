package TreesAndGraphs;

public class TreeTraversals {
    public static void main(String args[]){
        BST bst = new BST(20);
        Node root = bst.getBST();
        TreeTraversalsImpl treeTraversals = new TreeTraversalsImpl();
        treeTraversals.inOrderTraversal(root);
    }
}

class TreeTraversalsImpl{
    public void inOrderTraversal(Node root){
        if(root != null){
            inOrderTraversal(root.left);
            System.out.println(root.value);
            inOrderTraversal(root.right);
        }
    }
    public void preOrderTraversal(Node root){
        if(root != null){
            System.out.println(root.value);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
    public void postOrderTraversal(Node root){
        if(root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.value);
        }
    }
}
