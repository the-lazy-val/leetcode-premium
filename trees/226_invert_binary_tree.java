class Solution {
    
    public TreeNode invert(TreeNode root){
        if(root==null) return null;
        
        TreeNode temp = root.right;
        root.right = invert(root.left);
        root.left = invert(temp);
        
        return root;
    }
    
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        
        return invert(root);
    }
}
