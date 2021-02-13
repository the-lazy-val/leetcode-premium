/**
O(N) time
O(N) space for queue

Approach is to do normal level-order traversal, and just add the node to result if its the last node in that level
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
