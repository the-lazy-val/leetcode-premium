/**
My approach: bottom up
*/

class Solution {
    
    int max = Integer.MIN_VALUE;
    
    public int getLength(TreeNode root){
        if(root==null) return 0;
        
        int leftLength = getLength(root.left);
        int rightLength = getLength(root.right);
        
        int leftMax = (root.left!=null && root.left.val-root.val==1) ? 1+leftLength : 1;
        
        int rightMax = (root.right!=null && root.right.val-root.val==1) ? 1+rightLength : 1;
        
        max = Math.max(max, Math.max(leftMax, rightMax));
        
        return Math.max(leftMax, rightMax);
    }
    
    public int longestConsecutive(TreeNode root) {
        if(root==null) return 0;
        getLength(root);
        
        return max;
    }
}

/**
Top-down approach
*/
public int getLength(TreeNode root, int count, int prev){
        if(root==null) return count;
        
        count = (root.val - prev==1) ? count+1 : 1;
        
        int leftLength = getLength(root.left, count, root.val);
        int rightLength = getLength(root.right, count, root.val);
        
        return Math.max(count, Math.max(leftLength, rightLength));
    }
    
    public int longestConsecutive(TreeNode root) {
        if(root==null) return 0;
        
        return Math.max(getLength(root.left, 1, root.val), getLength(root.right, 1, root.val));
    }
