package LinkedList;

import LinkedList.Node;
import LinkedList.SinglyLinkedList;

public class ReversingSinglyLinkedList {
    public static void main(String args[]){
        int[] a = new int[10];
        a[0] = 1;
        System.out.println(a.length);
        SinglyLinkedList list = new SinglyLinkedList(1, true);
        Node output = Reverse_Recursive(list.head);
        while (output != null){
            System.out.println(output.value);
            output = output.next;
        }
    }

    // Clone approach
    public static Node Reverse(Node head){
        Node resultHead = null;
        while (head != null){
            Node n = new Node(head.value);
            n.next = resultHead;
            resultHead = n;
            head = head.next;
        }
        return resultHead;
    }
    // Iterative approach
    public static Node Reverse_Iterative(Node node){
        Node nextPtr = node.next;
        node.next = null;
        while (nextPtr != null){
            Node temp = nextPtr.next;
            nextPtr.next = node;
            node = nextPtr;
            nextPtr = temp;
        }
        return node;
    }
    // Recursive approach
    public static Node Reverse_Recursive(Node node){
        Node nextPtr = node.next;
        node.next = null;
        if(nextPtr == null){
            return  null;
        }
        Node temp = nextPtr.next;
        nextPtr.next = node;
        node = nextPtr;
        nextPtr = temp;
        node = Reverse_Recursive(node);

        return node;
    }
}
