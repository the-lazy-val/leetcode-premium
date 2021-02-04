/**
Naive solution: delete each node one by one
*/

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
    
    ArrayList<TreeNode> roots = new ArrayList();
    
    public boolean deleteNode(TreeNode root, int del){
        if(root==null) return false;
        if(root.val == del){
            if(root.left !=null) roots.add(root.left);
            if(root.right !=null) roots.add(root.right);
            roots.remove(root);
            return true;
        }else if(root.left!= null && root.left.val == del){
            TreeNode temp = root.left;
            
            root.left=null;
            
            if(temp.left !=null) roots.add(temp.left);
            if(temp.right !=null) roots.add(temp.right);
            return true;
        }else if(root.right!=null && root.right.val == del){
            TreeNode temp = root.right;
            
            root.right=null;
            
            if(temp.left !=null) roots.add(temp.left);
            if(temp.right !=null) roots.add(temp.right);
            return true;
        }else{
            return deleteNode(root.left, del) || deleteNode(root.right, del);
        }
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        roots.add(root);
        for(int del : to_delete){
            for(TreeNode r : roots){
                if(deleteNode(r, del)) break;
            }
        }
        
        return roots;
    }
}
