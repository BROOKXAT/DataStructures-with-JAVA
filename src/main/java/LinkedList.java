public class LinkedList {
    static class Node {
        int data ;
        Node next ;
        public Node(int data){
            this.data = data ;
            this.next = null ;
        }
    }
    public Node head  ;

    public LinkedList(int data){
        this.head = new Node(data) ;
    }

    public boolean isEmpty(){
        return head == null ;
    }

    public void insertAtBegening(int data){
        Node node = new Node(data) ;
        node.next = head ;
        this.head = node ;
    }
    public void insertAtEnd(int data){
        Node node = new Node(data) ;
        if ( head == null) this.head = node ;
        else {
            Node currentnode = this.head ;
            while (currentnode.next != null){
                currentnode = currentnode.next ;
            }
            currentnode.next = node ;

        }
    }

    public void delet(int data){
        if (head == null) System.out.println("empty list");
        if (head.data ==data) head = head.next ;
        Node currentnode = head;

        while (currentnode.next != null){
            if (currentnode.next.data == data){
                currentnode.next = currentnode.next.next ;
                System.out.println("item deleted");
                break;
            }
            currentnode = currentnode.next ;
        }
        System.out.println("item doesnt exist");
    }

    public void insertAtIndex(int data,int index){
        if (head == null && index ==0) this.head = new Node( data) ;
        int counter = 0 ;
        Node currentnode = this.head ;
        Node newnode = new Node(data);
        while (currentnode.next != null){
            if (counter == index-1){
                newnode.next = currentnode.next ;
                currentnode.next = newnode;
                break;
            }
            counter++ ;
            currentnode = currentnode.next ;

        }
        if (counter == index -1) currentnode.next = newnode;
        else System.out.println("index out of range");
    }

    @Override
    public String toString() {
        if (head == null) return "empty linked list" ;
        String tostring = "" ;
        Node currentnode = head ;
        while (currentnode.next != null){
            tostring += currentnode.data + "-->" ;
            currentnode = currentnode.next ;
        }
        tostring += currentnode.data ;
        return tostring ;
    }

    public static void main(String[] args) {
        LinkedList test = new LinkedList(90);
        test.insertAtBegening(89);
        test.insertAtEnd(76);
        test.insertAtIndex(456,1);
        test.insertAtIndex(88,5);
        System.out.println(test);
    }
}

