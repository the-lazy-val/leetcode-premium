/**

O(N) time
O(1) space (but internal stack due to recursion is there)
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)  return root;
        
        Node head = root;
        
        while(head!=null){
            Node dummy = new Node(0); //this will remain at start, since we need this reference for next head
            Node temp = dummy; //this one will move along next.. next.. next..
            
            while(head!=null){
                if(head.left!=null){
                    temp.next=head.left;
                    temp=temp.next;
                }
                
                if(head.right!=null){
                    temp.next=head.right;
                    temp=temp.next;
                }
                
                head=head.next; //At level-1, first head=2, now head=3
            }
            
            head = dummy.next; //next level
        }
        
        return root;
    }
}

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
