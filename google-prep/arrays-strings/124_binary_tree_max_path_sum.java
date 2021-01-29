//https://www.youtube.com/watch?v=TO5zsKtc1Ic

class Solution {
    int maxGlobal;
    
    public int maxSumHelper(TreeNode root) {
        
        // base case
        if (root == null) return 0; 
        
        // recursing through left and right subtree
        int leftMax = maxSumHelper(root.left);
        int rightMax = maxSumHelper(root.right);

        // finding all the four paths and the maximum between all of them
        int maxStraightPath = Math.max(root.val, (root.val + Math.max(leftMax, rightMax)));
        int maxBetweenStraightOrRoot = Math.max(maxStraightPath, leftMax + rightMax + root.val);
        
        // Storing the result in the maxGlobal holder
        maxGlobal = Math.max(maxGlobal, maxBetweenStraightOrRoot);
        
        // returning the value if root was part of the answer
        return maxStraightPath;

    }

    
    public int maxPathSum(TreeNode root) {
        maxGlobal = Integer.MIN_VALUE;
        maxSumHelper(root);
        return maxGlobal; // as maxGlobal will always store the result

    }
}
