public class BinaryTree {
    static class Node {
        public int data ;
        public Node leftChild ;
        public Node rightChild ;

        public Node(int data){
            this.data = data ;
            this.leftChild = null ;
            this.rightChild = null ;
        }
    }

    public Node root ;

    public BinaryTree(int data){
        this.root = new Node(data) ;
    }
}
