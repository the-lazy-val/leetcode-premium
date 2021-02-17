//Using the partial iterative in-order traversal technique

class Solution {
    Stack<TreeNode> st = new Stack();
    
    public void process(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        process(root);
        
        while(!st.isEmpty()){
            TreeNode popped = st.pop();
            if(popped.right!=null){
                process(popped.right);
            }
            
            if(popped.val == p.val){
                return (st.isEmpty()) ? null : st.pop();
            }
        }
        
        return null;
    }
}
