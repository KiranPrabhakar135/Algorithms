package LinkedList;

class Result{
    int index;
    int value;
    int length;
}

public class KthToLast {
    public static void main(String arg[]){
        SinglyLinkedList list = new SinglyLinkedList(1, true);
        int k = 4;
        Result result = printKthToLastIterative(list.head,list.head,k);
        //LinkedList.Result result =  printKthTOLastRecurssive(list.head, k, 0);
        System.out.println("The length of the linked list is: " + result.length);
        System.out.println("The value of " + k + "th to last is: " + result.value);
    }

    public static Result printKthTOLastRecurssive(Node head, int k, int len){
        len++;

        if(head == null){
            return null;
        }
        else{
            Result result = printKthTOLastRecurssive(head.next, k, len);
            if(result == null){
                result = new Result();
                result.index = len -1;
                result.value = head.value;
                result.length = len;
            }
            else{
                if(result.index == result.length - k){
                    return result;
                }
                Result newResult = new Result();
                newResult.value = head.value;
                newResult.length = result.length;
                newResult.index = result.index -1;
                result = newResult;
            }
            return result;
        }
    }

    public static Result printKthToLastIterative(Node head1, Node head2, int k){
        int len = 0;
        for (int i = 0; i < 4; i++) {
            head1 = head1.next;
            len++;
        }
        while (head1 != null){
            len++;
            head1 = head1.next;
            head2 = head2.next;
        }
        Result result = new Result();
        result.index = len - k;
        result.length = len;
        result.value = head2.value;
        return result;
    }
}
