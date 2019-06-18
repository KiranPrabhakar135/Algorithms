package TreesAndGraphs;

enum SubTreePosition{
    left,
    right
}

public class BalancedTree {
    public static void main(String[] args){
        BST tree = new BST(7);
        Node root = tree.getBST();
        //induceFailure(root);
        checkIfTreeIsBalanced(root);
        checkIfBinaryTreeBST(root);
    }

    private static void checkIfBinaryTreeBST(Node root){
        BalancedTreeImpl impl = new BalancedTreeImpl();
        if(impl.isBinaryTreeBST(root)){
            System.out.println("The Binary tree is a BST.");
        }
        else{
            System.out.println("The Binary tree is not a BST.");
        }
    }

    private static void checkIfTreeIsBalanced(Node root) {
        BalancedTreeImpl impl = new BalancedTreeImpl();
        if(impl.checkTreeBalanced(root)){
            System.out.println("Tree is Balanced");
        }
        else {
            System.out.println("Tree is not Balanced");
        }
    }

    private static void induceFailure(Node root) {
        Node temp = new Node();
        temp.right = new Node();
        temp.right.right = new Node();
        temp.right.right.right = new Node();
        Node temp2 = root;
        while (true){
            Node temp3 = temp2.right;
            if(temp3 == null){
                break;
            }
            temp2 = temp2.right;
        }
        temp2.right = temp;
    }
}

class BalancedTreeImpl{
    public boolean checkTreeBalanced(Node root){
        if(root == null){
            return false;
        }
        int leftSubTreeHeight = calculateSubTreeHeight(root, SubTreePosition.left);
        int rightSubTreeHeight = calculateSubTreeHeight(root, SubTreePosition.right);
        System.out.println("Height of Left Sub tree.." + leftSubTreeHeight);
        System.out.println("Height of Right Sub tree.." + rightSubTreeHeight);
        return Math.abs(leftSubTreeHeight-rightSubTreeHeight) <= 1;
    }

    private int calculateSubTreeHeight(Node root, SubTreePosition position){
        if(root == null){
            return 0;
        }
        if(position == SubTreePosition.left){
            return 1 + calculateSubTreeHeight(root.left, SubTreePosition.left);
        }
        else{
            return 1 + calculateSubTreeHeight(root.right, SubTreePosition.right);
        }
    }

    public boolean isBinaryTreeBST(Node root){
        if(root == null){
            return true;
        }
        if((root.left != null && root.left.value <= root.value) && (root.right != null && root.right.value > root.value)
            || (root.left == null && (root.right != null && root.right.value > root.value))
            || (root.right == null && (root.left != null && root.left.value <= root.value))
            || (root.left == null && root.right == null)){
            return isBinaryTreeBST(root.left) && isBinaryTreeBST(root.right);
        }
        else{
            return false;
        }
    }
}