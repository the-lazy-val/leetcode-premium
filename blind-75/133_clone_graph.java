/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneNode(Node[] originalVisited, Node[] newlyVisited, Node root){
        if(root==null) return null;
        if(originalVisited[root.val] != null) return newlyVisited[root.val];
        
        Node curr = new Node(root.val);
        
        originalVisited[root.val] = root;
        newlyVisited[root.val] = curr;
        
        ArrayList<Node> children = new ArrayList<Node>();
        
        for(Node n : root.neighbors){
            Node temp = cloneNode(originalVisited, newlyVisited, n);
            children.add(temp);
        }
        
        curr.neighbors = children;
        return curr;
    }
    
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        
        Node[] originalVisited = new Node[101];
        Node[] newlyVisited = new Node[101];
        
        return cloneNode(originalVisited, newlyVisited, node);
    }
}
