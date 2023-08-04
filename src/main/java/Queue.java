public class Queue {
    public int size ;
    public int[] items = new int[size] ;
    public int front,rear ;

    public Queue() {
        this.front = -1;
        this.rear = -1;
    }

    //
    public void enQueue (int item) {
        if (this.isFull()) {
            System.out.println("this queue is full");
        }
        else {
            if (front == -1 ) front = 0;
            rear++ ;
            items[rear] = item ;
            System.out.println("item added with success");
            }

        }
    // remove last item from the queue and return it
     public Integer deQueue(){
        if (this.isFull()){
            System.out.println("this queue is empty" );
            return null ;
        }
        else {
            int item = items[front] ;
            if (front>= rear)  {
                front = -1 ;

                rear = -1 ;
            }
            else {
                front ++ ;
            }
            System.out.println("item removed");
            return item ;
        }
    }

    public boolean isEmpty(){
        return  front == -1 ;
    }
    public boolean isFull(){
        return front == 0 && rear == size - 1 ;
    }

    public  Integer peek(){
        if (this.isEmpty()) {
            System.out.println("this queue is empty");
            return null ;

        }
        return items[front] ;
    }
}

