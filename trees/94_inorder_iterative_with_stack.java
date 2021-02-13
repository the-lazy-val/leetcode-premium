class Solution {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList();
        
        Stack<TreeNode> st = new Stack();
        
        TreeNode curr = root;
        
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.add(curr);
                curr=curr.left;
            }
            
            curr=st.pop();
            res.add(curr.val);
            curr=curr.right;
        }
        
        return res;
    }
}
