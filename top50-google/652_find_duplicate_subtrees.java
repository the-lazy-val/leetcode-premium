/**
Do inorder traversal
Store traverals in HashMap as (String -> List<Node>)

at the end, if any list in values of HashMap has length > 1 then add it to result

include "(" ")" or any string to ensure proper serialization
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
    
    HashMap<String, List<TreeNode>> hm = new HashMap();
    
    public String inorder(TreeNode root){
        if(root==null) return "";
        else{
            String trav = "("+inorder(root.left) + root.val + inorder(root.right)+")";
            
            hm.computeIfAbsent(trav, x -> new ArrayList()).add(root);
            
            return trav;
        }
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        String str = inorder(root);
        
        List<TreeNode> repeats = new ArrayList();
        
        for(List<TreeNode> group : hm.values()){
            if(group.size() > 1) repeats.add(group.get(0));
        }
        
        return repeats;
    }
}
