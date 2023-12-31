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
    // we use a one array argument because java is by default pass by value and if we dont do that the void function wont change the value of
    // the initial values of deepest node.
    public void findeDeepestNodeHelper(int data, int currentdepth, int deepestdeepth,Node currentnode,Node[] deepestnode) {
        if (currentnode == null) return;
        if (currentnode.data == data) {
            if (deepestnode[0] == null || currentdepth > deepestdeepth) {
                deepestnode[0] = currentnode;
                deepestdeepth = currentdepth;
            }
        }
        for (Node child : currentnode.sons) {
            findeDeepestNodeHelper(data, currentdepth + 1, deepestdeepth, child, deepestnode);
        }
    }

    public Node findDeepestNode(int data) {
        Node currentnode = this.root;
        Node[] deepestnode = {null} ;
        findeDeepestNodeHelper(data,0,0,currentnode,deepestnode);
        return deepestnode[0];
    }

    // add/delete nodes
    public void addNode(Node newnode, Node parentnode){
        if (parentnode == null) {
            System.out.println("parent node is null");
            return;
        }
        newnode.parent = parentnode ;
        parentnode.addSon(newnode);
    }
    // this function will delete the deepest node with the value given.(son of the node will be gone too as a result)
    public void deleteNode(int data ){
        Node nodeToDelete = this.findDeepestNode(data) ;
        if (nodeToDelete == null) {
            System.out.println("node doesnt exist");
            return;
        }
        nodeToDelete.parent.sons.remove(nodeToDelete) ;
        nodeToDelete.parent = null ;
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
        Node node1son2 = new Node(1);
        Node node2son1 = new Node(222) ;
        Node node2son2 = new Node(333) ;
        node1.addSon(node1son1);
        node1.addSon(node1son2);
        node2.addSon(node2son1);
        node2.addSon(node2son2);
        String s = test.generateTreeString(test.root,2);
        System.out.println(s);
        System.out.println("-------------------------");
        System.out.println(test.findDeepestNode(1).sons);
        test.deleteNode(2);
        System.out.println(test.generateTreeString(test.root,2));
    }
}
