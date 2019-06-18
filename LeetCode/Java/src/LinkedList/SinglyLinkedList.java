package LinkedList;

import LinkedList.Node;

import java.util.Iterator;

public class SinglyLinkedList implements Iterator<Node> {
    Node list;
    Node head;

    SinglyLinkedList(int value, boolean initializeSampleValues){
        list = new Node(value);
        head = list;
        if(initializeSampleValues){
            for (int i = 2; i <= 10; i++) {
                list.next = new Node(i);
                list = list.next;
            }
        }
    }
    public void insert(int value){
        list.next = new Node(value);
        list = list.next;
    }


    public boolean hasNext() {
        return list.next != null;
    }

    public Node next(){
        list = list.next;
        return list;
    }
}
