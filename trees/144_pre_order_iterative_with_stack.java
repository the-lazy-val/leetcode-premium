class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList();
        
        Stack<TreeNode> st = new Stack();
        
        if(root!=null) st.push(root);
        
        TreeNode curr;
        
        while(! st.isEmpty()){
            curr = st.pop();
            res.add(curr.val);
            
            if(curr.right !=null){
                st.push(curr.right);
            }
            
            if(curr.left!=null){
                st.push(curr.left);
            }
        }
        
        return res;
    }
}
