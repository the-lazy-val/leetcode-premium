/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    List<TreeNode> forest = new LinkedList();
    
    public TreeNode deleteNode(TreeNode root, HashSet<Integer> to_delete){
        
        if(root==null) return null;
        
        int rootVal = root.val;
        
        TreeNode deleteLeft = deleteNode(root.left, to_delete);
        TreeNode deleteRight = deleteNode(root.right, to_delete);
        
        if(to_delete.contains(rootVal)){
            to_delete.remove(rootVal);
            
            if(deleteLeft != null) forest.add(deleteLeft);
            
            if(deleteRight != null) forest.add(deleteRight);
            
            return null;
        }else{
            root.left = deleteLeft;
            root.right = deleteRight;
            
            return root;
        }
        
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        if(root==null) return new LinkedList();
        
        HashSet<Integer> toDelete = new HashSet<>();
        
        for(int n : to_delete){
            toDelete.add(n);
        }
        
        if(!toDelete.contains(root.val)){
            forest.add(root);
        }
        
        deleteNode(root, toDelete);
        
        return forest;
    }
}
