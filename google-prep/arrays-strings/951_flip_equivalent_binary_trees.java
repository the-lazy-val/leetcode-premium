/**
My solution: 0 ms
*/
class Solution {
    
    public String getReverseRepr(TreeNode root){
        StringBuilder str = new StringBuilder();
        if(root.right!=null)
            str.append(root.right.val);
        
        str.append(root.val);
        
        if(root.left!=null)
            str.append(root.left.val);
        
        return str.toString();
    }
    
    public String getRepr(TreeNode root){
        StringBuilder str = new StringBuilder();
        if(root.left!=null)
            str.append(root.left.val);
        
        str.append(root.val);
        
        if(root.right!=null)
            str.append(root.right.val);
        
        return str.toString();
    }
    
    public int checkEquality(TreeNode root1, TreeNode root2){
        String repr1 = getRepr(root1);
        String repr2 = getRepr(root2);
        if(repr1.equals(repr2)){
            return 0;
        }
        
        String repr3 = getReverseRepr(root1);
        
        if(repr3.equals(repr2)){
            return 1;
        }else{
            return -1;
        }
    }
    
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
            return true;
        else if((root1==null && root2!=null) || (root1!=null && root2==null)){
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
