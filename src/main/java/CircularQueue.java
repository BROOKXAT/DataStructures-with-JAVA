import java.util.Arrays;

public class CircularQueue {
    public  int maxSize ;
    public int currentSize ;
    public int front,rear ;
    public  int[] items  ;

    public CircularQueue(int maxSize){
        this.items = new int[maxSize] ;
        this.maxSize = maxSize ;
        this.front = -1 ;
        this.rear = maxSize -1 ;
        this.currentSize = 0 ;
    }

    public boolean isFull(){
        return currentSize == maxSize ;
    }
    public  boolean isEmpty(){
        return currentSize == 0 ;
    }

    // add an item o the Q and return its values (the item),  if the item is not added return null
    public Integer enQueue(int item){
        if (this.isFull()){
            System.out.println("the Q is full ");
            return null ;
        }
        else {
            if (front == -1 ) front = 0 ;
            rear = (rear+1)%maxSize ;
            items[rear] = item ;
            this.currentSize++ ;
            return item ;

        }
    }
    // remove the rear item from the Q and return its value .
    public Integer deQueue(){
        if (this.isEmpty()){
            System.out.println("this Q is empty");
            return  null ;

        }
        else{
            int item = items[front] ;
            front = (front+1)%maxSize ;
            this.currentSize-- ;
            return item ;
        }
    }

    @Override
    public String toString() {
        return "CircularQueue{" +
                "maxSize=" + maxSize +
                ", currentSize=" + currentSize +
                ", front=" + front +
                ", rear=" + rear +
                ", items=" + Arrays.toString(items) +
                '}';
    }

    public static void main(String[] args) {
        CircularQueue Q = new CircularQueue(4);
        Q.deQueue() ;
        Q.enQueue(20);
        Q.enQueue(30);
        Q.enQueue(55) ;
        System.out.println(Q) ;
        Q.deQueue() ;
        System.out.println(Q);
        Q.deQueue();
        Q.deQueue();
        System.out.println(Q);
        Q.enQueue(77);
        System.out.println(Q);
        Q.enQueue(100);
        Q.enQueue(200);
        Q.enQueue(300);
        System.out.println(Q);
        Q.enQueue(349857);
    }
}
