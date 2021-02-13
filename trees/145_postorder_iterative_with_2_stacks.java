class Solution {
    
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList();
        
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        
        if(root!=null) s1.push(root);
        
        while(!s1.isEmpty()){
            TreeNode curr = s1.pop();
            if(curr.left!=null) s1.push(curr.left);
            if(curr.right!=null) s1.push(curr.right);
            
            s2.push(curr);
        }
        
        while(!s2.isEmpty()){
            res.add(s2.pop().val);
        }
        
        return res;
    }
}
