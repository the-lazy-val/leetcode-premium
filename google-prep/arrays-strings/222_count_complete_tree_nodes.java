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
*/
