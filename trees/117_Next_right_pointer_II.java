/**
BFS approach
O(N) time
O(N) space for queue
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)  return root;
        
        Queue<Node> q = new LinkedList();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            Node dummy = new Node(0);
            while(size>0){
                Node temp = q.remove();
                dummy.next = temp;
                dummy = dummy.next;
                
                if(temp.left!=null) q.add(temp.left);
                
                if(temp.right!=null) q.add(temp.right);
                
                size--;
            }
        }
        
        return root;
    }
}
