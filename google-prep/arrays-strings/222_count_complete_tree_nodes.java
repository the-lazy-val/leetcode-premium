/**
My solution: 0 ms
time comp: O(N)
*/

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }else if(root.left==null && root.right==null){
            return 1;
        }else if(root.left==null){
            return 1 + countNodes(root.right);
        }else if(root.right==null){
            return 1 + countNodes(root.left);
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}

/**
There could be a better solution, since in a complete binary tree
all levels have 2^h nodes.
h -> 0,1,2 (level of that layer)

except the last layer, which may have 1 to 2^h nodes


Since in Binary Complete tree, at last level, all nodes are towards left
We can Binary Search to find the how many nodes are there in the last level

https://docs.google.com/document/d/1csfxOIOuV6xkuFJ8cT3SQUasO7drOgqyIRwtXkbB9mU/edit?usp=sharing

Time complexity = O(d^2) = O(log^2 N)
*/

class Solution {
    
    public int getDepth(TreeNode root){
        int depth = 0;
        while(root.left!=null){
            root = root.left;
            depth++;
        }
        
        return depth;
    }
    
    public boolean exists(TreeNode node, int idx, int d){ 
        int left = 0;
        int right = (int)Math.pow(2, d) - 1;
        int pivot;
        
        //doing binary search, here for loop is limiting the iteration to depth so we can't go further than last level
        
        //observe node.left & node.right, with each iteration we are going down, 
        //with respect to what the position of current node is in respect to the PIVOT on last level
        
        for(int i = 0; i < d; ++i) {
            pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            }
            else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }
    
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int d = getDepth(root);
        
        if(d==0) return 1;
        
        int left = 0;
        int right = (int)Math.pow(2, d) - 1;
        while(left<=right){
            int pivot = left + (right-left)/2;
            if(exists(root, pivot, d)) left=pivot+1;
            else right=pivot-1;
        }
        
        return (int)Math.pow(2,d)-1+left;
    }
}
