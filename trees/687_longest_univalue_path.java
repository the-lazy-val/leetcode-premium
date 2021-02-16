class Solution {
    
    int max = 0;
    
    public int maxPath(TreeNode root){
        if(root == null) return 0;
        
        int rootVal = root.val;
        
        int leftLen = maxPath(root.left);
        int rightLen = maxPath(root.right);
        
        if(root.left!=null && root.left.val == rootVal && root.right!=null && root.right.val == rootVal){
            max = Math.max(max, 2+leftLen+rightLen); //notice 2+ since 2 edges if both nodes are considered
            return (1 + Math.max(leftLen, rightLen));
        }else if(root.left!=null && root.left.val == rootVal){
            max = Math.max(max, 1+leftLen);
            return 1+leftLen;
        }else if(root.right!=null && root.right.val == rootVal){
            max = Math.max(max, 1+rightLen);
            return 1+rightLen;
        }
        
        return 0;
    }
    
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        
        maxPath(root);
        
        return max;
    }
}
