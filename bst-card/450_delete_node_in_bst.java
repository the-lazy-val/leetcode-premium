class Solution {
    
    public int successor(TreeNode root){
        root = root.right;
        while(root.left!=null){
            root = root.left;
        }
        
        return root.val;
    }
    
    public int predecessor(TreeNode root){
        root=root.left;
        while(root.right!=null){
            root = root.right;
        }
        
        return root.val;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root==null) return null;
        
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left==null && root.right==null){
                root=null;
            }else if(root.left!=null){
                int predecessorValue = predecessor(root);
                root.val = predecessorValue;
                root.left = deleteNode(root.left, predecessorValue);
            }else{
                int successorValue = successor(root);
                root.val = successorValue;
                root.right = deleteNode(root.right, successorValue);
            }
        }
        
        return root;
    }
}
