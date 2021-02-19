class Solution {
    
    public void leftBoundary(TreeNode root, List<Integer> res){
        if(root==null) return;
        if(root.left!=null){
            res.add(root.val); //first add value, then call left
            leftBoundary(root.left, res);
        }else if(root.right!=null){
            res.add(root.val);
            leftBoundary(root.right, res);
        }
    }
    
    public void leaves(TreeNode root, List<Integer> res){
        if(root==null) return;
        leaves(root.left, res);
        if(root.left==null && root.right==null) res.add(root.val);
        leaves(root.right, res);
    }
    
    public void rightBoundary(TreeNode root, List<Integer> res){
        if(root==null) return;
        if(root.right!=null){
            rightBoundary(root.right, res); //opposite to leftBoundary function, first call right then add value
            res.add(root.val); //this will reverse the order (as we need reverse boundaery from right)
        }else if(root.left!=null){
            rightBoundary(root.left, res);
            res.add(root.val);
        }
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new LinkedList();
        if(root==null) return res;
        
        res.add(root.val);
        
        if(root.left==null && root.right==null){
            return res;
        }
        
        
        leftBoundary(root.left, res);
        leaves(root, res);
        rightBoundary(root.right, res);
        
        return res;
    }
}
