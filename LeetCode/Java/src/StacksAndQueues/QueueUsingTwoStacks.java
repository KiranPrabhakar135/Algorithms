package StacksAndQueues;

import LinkedList.Node;

public class QueueUsingTwoStacks {
    public static void main(String[] args){
        QueueUsingTwoStacksImpl queue = new QueueUsingTwoStacksImpl();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}

class QueueUsingTwoStacksImpl{
    StackUsingNode stack1 = new StackUsingNode();
    StackUsingNode stack2 = new StackUsingNode();

    public void push(int x){
        while (!stack2.isEmpty()){
            Node top = stack2.pop();
            if(top != null){
                stack1.push(top.value);
            }
        }
        stack1.push(x);
    }

    public int peek(){
        transformFromS1ToS2();
        Node top = stack2.peek();
        if(top != null){
            return  top.value;
        }
        return -1;
    }

    public int pop(){
        transformFromS1ToS2();
        Node top = stack2.pop();
        if(top != null){
            return  top.value;
        }
        return -1;
    }

    private void transformFromS1ToS2(){

        while (!stack1.isEmpty()){
            System.out.println("performing transfer.");
            Node top = stack1.pop();
            if(top != null){
                stack2.push(top.value);
            }
        }
    }
}