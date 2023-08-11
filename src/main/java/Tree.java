import java.util.ArrayList;

public class Tree {
    static  class Node {
        int data ;
        Node parent ;
        ArrayList<Node> sons = new ArrayList<Node>();
        public Node(int data) {
            this.data = data ;
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
    // find operations
    public void findeDeepestNodeHelper(int data, int currentdepth, int deepestdeepth,Node currentnode,Node deepestnode) {
        if (currentnode == null) return;
        if (currentnode.data == data) {
            if (deepestnode == null || currentdepth > deepestdeepth) {
                deepestnode = currentnode;
                deepestdeepth = currentdepth;
            }
        }
        for (Node child : currentnode.sons) {
            findeDeepestNodeHelper(data, currentdepth + 1, deepestdeepth, child, deepestnode);
        }
    }

    public Node findDeepestNode(int data) {
        Node currentnode = this.root;
        int currentdepth = 0;
        Node deepestnode = null ;
        findeDeepestNodeHelper(data,0,0,currentnode,deepestnode);
        return deepestnode;

    }

    // add/delete nodes
    public void addNode(Node newnode, Node parentnode){
        newnode.parent = parentnode ;
        parentnode.addSon(newnode);
    }
    // this function will delete the deepest node with the value given.(son of the node will be gone too as a result)
    public void deleteNode(int data ){

    }


    private String generateTreeString(Node node, int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  ".repeat(Math.max(0, depth)));
        stringBuilder.append(node.data).append("\n");

        for (Node child : node.sons) {
            stringBuilder.append(generateTreeString(child, depth + 1));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Tree test = new Tree(0) ;
        Node node1= new Node(1) ;
        Node node2= new Node(2) ;
        test.addNode(node1,test.root);
        test.addNode(node2,test.root);
        Node node1son1 = new Node(11);
        Node node1son2 = new Node(22);

        node1.addSon(node1son1);
        node1.addSon(node1son2);
        String s = test.generateTreeString(test.root,2);
        System.out.println(s);
    }
}
