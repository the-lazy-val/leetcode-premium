class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
       if(root==null) return null;  //base case
        
        if(root.val == p.val || root.val == q.val) return root;  //base case2: if any one is found, return it
        
        //now search deeper if nothing found yet
        
        TreeNode leftSearchResult = lowestCommonAncestor(root.left, p, q);
        
        TreeNode rightSearchResult = lowestCommonAncestor(root.right, p, q);
        
        if(leftSearchResult==null) return rightSearchResult; //if nothing found on left, return right
        
        if(rightSearchResult==null) return leftSearchResult; //if nothing found on right, return left
        
        return root; //this means, above two conditions failed, i.e. we found one element on each side so this is LCA
    }
}
