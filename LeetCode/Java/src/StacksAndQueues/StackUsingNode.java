package StacksAndQueues;

import LinkedList.Node;

public class StackUsingNode {
    int length;
    int capacity;
    private boolean hasCapacityConstraint;
    Node top;
    Node bottom;

    public StackUsingNode()
    {
    }
    public StackUsingNode (int capacity){
        this.capacity = capacity;
        this.hasCapacityConstraint = true;
    }
    public void push(int x){
        if(canPush()){
            if(top == null){
                top = new Node(x);
                bottom = top;
            }
            else{
                Node temp = top;
                top.next = new Node(x);
                top = top.next;
                top.prev = temp;
            }
            this.length++;
        }
    }

    public Node pop(){
        if(canPopOrPeek()){
            Node temp = top;
            top = top.prev;
            length--;
            return temp;
        }
        return null;
    }
    public Node peek(){
        if(canPopOrPeek()){
            return top;
        }
        return null;
    }
    public boolean isEmpty(){
        return length == 0;
    }
    public boolean canPush(){
        return hasCapacityConstraint ? length < capacity : !hasCapacityConstraint;
    }
    public boolean canPopOrPeek(){
        return length > 0;
    }

    public void reArrange(StackUsingNode nextStack){
        this.push(nextStack.bottom.value);
        Node temp = nextStack.bottom.next;
        nextStack.bottom.next = null;
        nextStack.bottom = temp;
        nextStack.length--;
    }
}