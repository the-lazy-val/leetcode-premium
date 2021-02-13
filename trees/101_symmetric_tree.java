class Solution {
    
    public boolean checkSymmetric(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        
        return (left.val == right.val) 
            && checkSymmetric(left.left, right.right) 
            && checkSymmetric(left.right, right.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return checkSymmetric(root.left, root.right);
    }
}
