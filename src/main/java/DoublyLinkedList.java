public class DoublyLinkedList {
    static class Node {
        int data ;
        Node next   ;
        Node previous  ;

        public Node (int data){
            this.data = data ;
            this.next = null ;
            this.previous = null ;
        }
    }
    public Node head ;

    public DoublyLinkedList(){
        this.head = null ;
    }

    public DoublyLinkedList(int data){
        this.head = new Node(data);
    }
    // insertions
    public void insertAtBeginning(int data){
        if (this.head == null) this.head = new Node(data);
        Node newnode = new Node(data) ;
        newnode.next = this.head ;
        this.head.previous = newnode ;
    }

    public void insertAtEnd(int data){
        if (this.head == null) this.head = new Node(data);
        Node newnode = new Node(data) ;
        Node currentnode = this.head ;
        while (currentnode.next != null){
            currentnode = currentnode.next ;
        }
        currentnode.next = newnode ;
        newnode.previous = currentnode ;
    }

    public void insertAfterNode(Node existingnode, int data){
        Node newnode = new Node(data) ;
        Node oldNext = existingnode.next;
        oldNext.previous = newnode ;
        newnode.next = oldNext ;
        newnode.previous = existingnode;
        existingnode.next = newnode ;

    }
    public void insertBeforNode(Node existingnode, int data){
        Node newnode = new Node(data) ;
        Node oldPrevious = existingnode.previous ;
        oldPrevious.next = newnode ;
        newnode.previous = oldPrevious ;
        newnode.next = existingnode ;
        existingnode.previous = newnode ;
    }
}
