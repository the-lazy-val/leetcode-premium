//solution is similar to #124 (max path sum, root node not necessarily in path)

class Solution {
    int maxLength;
    
    public int maxLengthHelper(TreeNode root) {
        
        if(root == null) return 0;
        
        // base case
        if (root.left == null && root.right == null) return 0; 
        
        // recursing through left and right subtree
        int leftMax = maxLengthHelper(root.left);
        int rightMax = maxLengthHelper(root.right);

        // if node is in straight path
        int maxStraightPath = 1 + Math.max(leftMax, rightMax);
        
        int maxRootPath = 0;
        //if node is root
        if(root.left==null)
            maxRootPath = rightMax + 1;
        else if(root.right==null)
            maxRootPath = leftMax + 1;
        else
            maxRootPath = rightMax + leftMax + 2;
        
        int maxBetweenStraightOrRoot = Math.max(maxStraightPath, maxRootPath);
        
        // Storing the result in the maxLength holder
        maxLength = Math.max(maxLength, maxBetweenStraightOrRoot);
        
        // returning the value if root was part of the answer
        return maxStraightPath;

    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxLength = 0;
        maxLengthHelper(root);
        return maxLength;
    }
}
