class Solution {
    public Node treeToDoublyList(Node root) {
        
        if(root==null) return root;
        
        Node head = new Node();
        Node dummy = head;
        
        Stack<Node> st = new Stack();
        Node curr = root;
        
        while(curr!=null || !st.isEmpty()){
            
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            
            curr = st.pop();
            dummy.right = curr;
            
            Node temp = curr.right;
            
            curr.left=dummy;
            curr.right=head.right;
            dummy=curr;
            
            curr=temp;
        }
        
        if(head.right !=null){
            head.right.left=dummy;
        }
        
        return head.right;
        
    }
}
