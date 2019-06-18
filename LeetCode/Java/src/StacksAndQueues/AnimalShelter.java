package StacksAndQueues;

public class AnimalShelter {
    public static void main(String args[]){
        AnimalShelterImpl shelter = new AnimalShelterImpl();
        shelter.enqueue(AnimalType.cat.getValue());
        shelter.enqueue(AnimalType.cat.getValue());
        shelter.enqueue(AnimalType.cat.getValue());
        shelter.enqueue(AnimalType.dog.getValue());
        shelter.enqueue(AnimalType.dog.getValue());
        shelter.enqueue(AnimalType.dog.getValue());
        shelter.enqueue(AnimalType.cat.getValue());
        shelter.enqueue(AnimalType.dog.getValue());
        System.out.println(shelter.deQueueAny());
        System.out.println(shelter.deQueue(AnimalType.dog.getValue()));
        System.out.println(shelter.tempQueueSize());
    }
}

enum AnimalType{
    cat(0),
    dog(1);
    private int value;
    private AnimalType(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
class AnimalShelterImpl{
    private QueueUsingLinkedList<Integer> shelter = new QueueUsingLinkedList();
    private QueueUsingLinkedList<Integer> tempQueue = new QueueUsingLinkedList();

    public void enqueue(int  animal){
        shelter.enqueue(animal);
    }

    public int tempQueueSize(){
        return tempQueue.size();
    }

    public int deQueueAny(){
        if(!tempQueue.isEmpty()){
            return tempQueue.dequeue();
        }
        else{
            return shelter.dequeue();
        }
    }

    public int deQueue(int animalType){
        if(!tempQueue.isEmpty() && tempQueue.peek() == animalType){
            return tempQueue.dequeue();
        }
        else {
            while(shelter.peek() != animalType){
                tempQueue.enqueue(shelter.dequeue());
            }
            return shelter.dequeue();
        }
    }
}