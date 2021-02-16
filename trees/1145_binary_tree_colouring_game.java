class Solution {
    
    public int childrenCount(TreeNode root){
        if(root==null) return 0;
        
        return 1 + childrenCount(root.left) + childrenCount(root.right);
    }
    
    public TreeNode findx(TreeNode root, int x){
        if(root==null) return null;
        
        if(root.val == x) return root;
        
        TreeNode left = findx(root.left, x);
        if(left!=null) return left;
        TreeNode right = findx(root.right, x);
        return right;
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        TreeNode xnode = findx(root, x);
        
        int leftChildren = childrenCount(xnode.left);
        int rightChildren = childrenCount(xnode.right);
        
        int remaining = n - (1+leftChildren+rightChildren);
        
        if(remaining >1+leftChildren+rightChildren || leftChildren>1+rightChildren+remaining || rightChildren>1+leftChildren+remaining){
            return true;
        }
        
        return false;
    }
}
