package StacksAndQueues;

import LinkedList.Node;

public class SortUsingTwoStacks {
    public static void main(String args[]){
        SortUsingTwoStacksImpl sortImpl = new SortUsingTwoStacksImpl();
        sortImpl.insertData();
        sortImpl.sortStack1();
    }
}
class SortUsingTwoStacksImpl{
    StackUsingNode stack1 = new StackUsingNode();
    StackUsingNode stack2 = new StackUsingNode();
    Node stack1Top = null;
    Node stack2Top = null;

    public void insertData(){
        for (int i = 0; i < 10; i++) {
            int randomValue = (int)(Math.random()*100);
            stack1.push(randomValue);
        }
    }

    public void pushStack1(int x){
       if(stack1Top == null){
           stack1Top = stack1.peek();
       }

       stack1.push(x);
    }

    public Node popStack1(){
        Node top = stack1.pop();
        if(top == stack1Top){
            stack1Top = null;
        }
        return top;
    }

    public void sortStack1(){
        while (!stack1.isEmpty()){
            Node temp = stack1.pop();
            while (!stack2.isEmpty() && stack2.peek().value > temp.value){
                    stack1.push(stack2.pop().value);
            }
            stack2.push(temp.value);
        }
        while (!stack2.isEmpty()){
            int value = stack2.pop().value;
            System.out.println(value);
            stack1.push(value);
        }
    }
}