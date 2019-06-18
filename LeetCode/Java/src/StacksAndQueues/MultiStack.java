package StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

public class MultiStack{
    public static void main(String args[]) throws Exception{
        MultiStack1 stack = new MultiStack1();
        InsertTestData(stack);
        //PopAll(stack);
        System.out.println(stack.popAt(2));

    }

    private static void InsertTestData(MultiStack1 stack) {
        for (int i = 1; i <= 20 ; i++) {
            stack.push(i);
        }
        System.out.println(stack.size());
    }

    private static void PopAll(MultiStack1 stack) throws Exception {
        for (int i = 0; i < 20; i++) {
            if(i % 5 == 0){
                System.out.println("New Stack ....");
            }
            System.out.println(stack.pop());
        }
    }
}

class MultiStack1 {
    List<StackUsingNode> stacks = new ArrayList<>();
    int threshold = 5;
    StackUsingNode last;

    public void push(int x){
        StackUsingNode currentTop = getTop();
        if(currentTop == null || !currentTop.canPush()){
            StackUsingNode newStack = new StackUsingNode(threshold);
            newStack.push(x);
            stacks.add(newStack);
        }
        else{
            currentTop.push(x);
        }
    }

    public int pop() throws Exception{
        StackUsingNode topStack = getTop();
        if(topStack == null){
            throw new Exception("Noting present in stack to pop.");
        }
        int value = topStack.pop().value;
        if(!topStack.canPopOrPeek()){
            stacks.remove(size() -1);
        }
        return value;
    }

    public int popAt(int index) throws Exception{
        StackUsingNode stack = getStack(index);
        if(stack != null)
        {
            int topNodeValue = stack.pop().value;
            if(!stack.canPopOrPeek()){
                stacks.remove(index);
            }
            leftShift(stack, index);
            return topNodeValue;
        }
        throw new Exception("Noting present in stack to pop.");
    }

    public  void  leftShift(StackUsingNode stack, int index){
        StackUsingNode nextStack = getStack(index + 1);
        if(nextStack == null){
            return;
        }
        stack.reArrange(nextStack);
        leftShift(nextStack, index +1);
    }

    public int size(){
        return stacks.size();
    }
    public StackUsingNode getTop(){
        int size = size();
        if(size == 0){
           return null;
        }
        return stacks.get(size - 1);
    }

    public StackUsingNode getStack(int index) {
        if(index < 0 || index >= size()){
            return null;
        }
        return stacks.get(index);
    }
}

