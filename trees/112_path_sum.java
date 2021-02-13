/**
If there is a path from root to leaf whose sum is target
*/

class Solution {
    public boolean checkPathPreOrder(TreeNode root, int targetSum){
        if(targetSum-root.val == 0 && root.left==null && root.right==null) return true;
        
        boolean res = false;
        
        if(root.left!=null){
            res = res || checkPathPreOrder(root.left, targetSum-root.val);
        }
        
        if(root.right!=null){
            res = res || checkPathPreOrder(root.right, targetSum-root.val);
        }
        
        return res;
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return checkPathPreOrder(root, targetSum);
    }
}
