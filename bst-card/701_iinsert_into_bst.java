class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root==null) return new TreeNode(val);
        
        TreeNode curr = root;
        
        boolean flag=true;
        
        while(curr!=null){
            if(val < curr.val){
                if(curr.left==null){
                    curr.left = new TreeNode(val);
                    break;
                }
                curr=curr.left;
            }else{
                if(curr.right==null){
                    curr.right = new TreeNode(val);
                    break;
                }
                curr=curr.right;
            }
        }
        
        return root;
    }
}
