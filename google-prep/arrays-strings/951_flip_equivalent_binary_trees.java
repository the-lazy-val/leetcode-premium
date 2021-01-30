class Solution {
    
    public StringBuilder getRepr(TreeNode root){
        StringBuilder str = new StringBuilder();
        if(root.left!=null)
            str.append(root.left.val);
        
        str.append(root.val);
        
        if(root.right!=null)
            str.append(root.right.val);
        
        return str;
    }
    
    // public void flip(TreeNode root){
    //     rootLeft = root.left;
    //     root.left = root.right;
    //     root.right = rootLeft;
    // }
    
    public int checkEquality(TreeNode root1, TreeNode root2){
        StringBuilder repr1 = getRepr(root1);
        StringBuilder repr2 = getRepr(root2);
        if(repr1.toString().equals(repr2.toString())){
            return 0;
        }
        
        repr1.reverse();
        
        if(repr1.toString().equals(repr2.toString())){
            return 1;
        }else{
            return -1;
        }
    }
    
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
            return true;
        else if((root1==null && root2!=null) || (root1!=null && root2==null))
            return false;
        else{
            if(root1.val != root2.val){
                return false;
            }else{
                int check = checkEquality(root1, root2);
                if(check==0){
                    return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
                }else if(check==1){
                    return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
                }else{
                    return false;
                }
            }
        }
    }
}
