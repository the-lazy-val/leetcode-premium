class Solution {
    
    public boolean check(TreeNode a, TreeNode b){
        if(a==null && b==null) return true;
        
        if(a==null || b==null) return false;
        
        if(a.val != b.val) return false;
        
        boolean cond1 = check(a.left, b.left) && check(a.right, b.right); //check direct
        
        boolean cond2 = check(a.left, b.right) && check(a.right, b.left); //check flip
        
        return cond1 || cond2; //if either is true, then they are equivalent
    }
    
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return check(root1, root2);
    }
}
