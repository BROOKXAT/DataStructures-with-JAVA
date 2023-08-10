import java.util.ArrayList;

public class Tree {
    static  class Node {
        int data ;
        Node parent ;
        ArrayList<Node> sons = new ArrayList<Node>();
        public Node(int data) {
            this.parent = null ;
        }

        public void addSon(Node son ){
            this.sons.add(son) ;
            son.parent = this ;
        }

        public void deletSon(Node son){
            this.sons.remove(son) ;
        }

    }

    public Node root ;
    public int height ;

    public Tree(int data){
        this.root = new Node(data) ;
        this.height = 0 ;
    }
    // add/delete nodes
    public void addNode(Node newnode, Node parentnode){
        newnode.parent = parentnode ;
        parentnode.addSon(newnode);
    }

    @Override
    public String toString() {
        String treeTostring = "" ;
        return treeTostring ;
    }
}
