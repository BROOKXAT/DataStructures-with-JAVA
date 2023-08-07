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

        @Override
        public String toString(){
            return  Integer.toString(this.data);
        }
    }
    public Node head ;

    public DoublyLinkedList(){
        this.head = null ;
    }

    public DoublyLinkedList(int data){
        this.head = new Node(data);
    }
    //

    public Node getLastNode(){
        if (this.head == null) return  null ;
        Node currentnode = this.head ;
        while (currentnode.next != null){
            currentnode = currentnode.next ;
        }
        return currentnode ;
    }
    public Node getElementByIndex(int index){
        if (this.head == null ){
            System.out.println("empty list");
            return  null ;
        }
        else {
            Node currentnode = this.head ;
            int counter = 0 ;
            while (currentnode.next != null){
                currentnode = currentnode.next ;
                counter ++ ;
                if (counter == index) return currentnode ;
            }
            System.out.println("index out of range");
            return null ;
        }
    }

    // insertions

    public void insertNodeByIndex(int index,int data){
        if (head == null && index ==0) this.head = new DoublyLinkedList.Node( data) ;
        int counter = 0 ;
        DoublyLinkedList.Node currentnode = this.head ;
        DoublyLinkedList.Node newnode = new DoublyLinkedList.Node(data);
        while (currentnode.next != null){
            if (counter == index-1){
                newnode.next = currentnode.next ;
                newnode.previous = currentnode ;
                currentnode.next.previous = newnode;
                currentnode.next = newnode ;
                break;
            }
            counter++ ;
            currentnode = currentnode.next ;

        }
        if (counter == index -1){
            currentnode.next = newnode;
            newnode.previous = currentnode ;
        }
        else System.out.println("index out of range");
    }
    public void insertAtBeginning(int data){
        if (this.head == null) this.head = new Node(data);
        Node newnode = new Node(data) ;
        newnode.next = this.head ;
        this.head.previous = newnode ;
        this.head = newnode ;
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

    // deletion

    public void deleteFirstNode(){
        if ( this.head == null) {
            System.out.println("empty list");
        }
        this.head = this.head.next ;
        this.head.previous = null ;
        System.out.println("first element deleted with success");
    }

    public void deleteLastNode(){
        if (this.head == null) {
            System.out.println("empty linked list");
        }
        Node currentnode = this.head ;
        while (currentnode.next != null){
            currentnode = currentnode.next ;
        }
        currentnode.previous.next = null ;
    }

    public void deletNodeByIndex(int index){
        Node node = this.getElementByIndex(index);
        if (node != null){
            Node  oldprevious = node.previous ;
            Node oldnext = node.next ;
            oldprevious.next = oldnext ;
            oldnext.previous = oldprevious ;
        }

    }

    // concatenate
    public void appendList(DoublyLinkedList list2){
        if(this.head == null && list2.head == null ) return ;
        if (list2.head == null) return ;
        Node list1end = this.getLastNode() ;
        Node head2copy = list2.head ;
        list1end.next = head2copy ;
        head2copy.previous = list1end ;
    }




    @Override
    public String toString() {
        if (head == null) return "empty linked list" ;
        String tostring = "" ;
        DoublyLinkedList.Node currentnode = head ;
        while (currentnode.next != null){
            tostring += currentnode.data + "-->" ;
            currentnode = currentnode.next ;
        }
        tostring += currentnode.data ;
        return tostring ;
    }

    public static void main(String[] args) {
        DoublyLinkedList dlinkedList = new DoublyLinkedList(54) ;
        dlinkedList.insertAtBeginning(7);
        dlinkedList.insertAtEnd(9);
        Node existingnode = dlinkedList.getElementByIndex(1);
        System.out.println(existingnode);
        dlinkedList.insertAfterNode(existingnode,89);
        dlinkedList.insertBeforNode(existingnode,770);
        System.out.println(dlinkedList);
        dlinkedList.insertNodeByIndex(6,6);
        dlinkedList.insertNodeByIndex(5,5);
        dlinkedList.insertNodeByIndex(2,2);
        System.out.println(dlinkedList);
        dlinkedList.deletNodeByIndex(3);
        dlinkedList.deleteFirstNode();
        dlinkedList.deleteLastNode();
        System.out.println(dlinkedList);
        DoublyLinkedList list2 = new DoublyLinkedList(0) ;
        list2.insertAtEnd(0);
        list2.insertAtEnd(0);
        list2.insertAtEnd(0);
        dlinkedList.appendList(list2);
        System.out.println(dlinkedList);
    }
}
