import java.util.*;
public class queue_array{


    static class Queue{
        static int arr[];
        static int size;
        static int rear = -1;
    

    Queue(int size){
        arr =new int[size];
        this.size = size ;
    }
    public static boolean isEmpty(){

        return rear == -1;
    }

    public static void add(int data){
        if(rear == size-1){
            System.out.println("full queue");
            return;
        }
        rear++;
        arr[rear]=data;
    }
    public static int remove(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }
        int front = arr[0];
        for(int i = 0;i<rear;i++){
            arr[i]=arr[i+1];

        }
        rear--;
        return front;
    }
    public static int peek(){

        if(isEmpty()){
            System.out.println("Empty queue");
            return -1;
        }
        return arr[0];
    }

    
}
    public static void main(String[] args) {

        Queue queue=new Queue(5);
        queue.add(45);
        queue.add(7);
        queue.add(9);
        queue.add(3);
        queue.add(55);

        System.out.println(queue.peek());
        
    }

}