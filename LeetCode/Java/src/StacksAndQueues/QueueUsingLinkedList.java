package StacksAndQueues;

import java.util.LinkedList;

public class QueueUsingLinkedList<T> {
    private LinkedList<T> queue;
    public QueueUsingLinkedList(){
        queue = new LinkedList<>();
    }

    public void enqueue(T x){
        queue.push(x);
    }

    public T dequeue(){
         return  queue.removeLast();
    }

    public T peek(){
        return queue.peekLast();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int size(){
        return queue.size();
    }
}
