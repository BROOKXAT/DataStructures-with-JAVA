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
        System.out.println(test);
    }
}

