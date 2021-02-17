//Recursive solution + DP : 2ms

//https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem

class Solution {
    
    HashMap<TreeNode, Integer> dp = new HashMap();
    
    public int getMax(TreeNode root){
        if(root==null) return 0;
        
        if(dp.containsKey(root)) return dp.get(root);
        
        int sum = 0;
        
        if(root.left!=null){
            sum+= getMax(root.left.left) + getMax(root.left.right);
        }
        
        if(root.right!=null){
            sum+= getMax(root.right.left) + getMax(root.right.right);
        }
        
        int max = Math.max(sum + root.val, getMax(root.left)+getMax(root.right));
        
        dp.put(root, max);
        
        return max;
    }
    
    public int rob(TreeNode root) {
        return getMax(root);
    }
}


//Recursive solution : 634 ms

class Solution {
    
    public int getMax(TreeNode root){
        if(root==null) return 0;
        
        int sum = 0;
        
        if(root.left!=null){
            sum+= getMax(root.left.left) + getMax(root.left.right);
        }
        
        if(root.right!=null){
            sum+= getMax(root.right.left) + getMax(root.right.right);
        }
        
        return Math.max(sum + root.val, getMax(root.left)+getMax(root.right));
    }
    
    public int rob(TreeNode root) {
        return getMax(root);
    }
}

/**
wrong solution

doing pre-order to array then DP

class Solution {
    
    LinkedList<Integer> li = new LinkedList();
    
    public void preOrder(TreeNode root){
        if(root==null) return;
        
        li.add(root.val);
        
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public int rob(TreeNode root) {
        
        if(root==null) return 0;
        
        if(root.left==null && root.right==null) return root.val;
        
        preOrder(root);
        
        int[] preorder = li.stream().mapToInt(i->i).toArray();
        
        int[] dp = new int[preorder.length];
        
        dp[0] = preorder[0];
        
        if(preorder[1]>preorder[0]){
            dp[1] = preorder[1];
        }else{
            dp[1] = dp[0];
        }
        
        for(int i=2; i<dp.length; i++){
            if(preorder[i]+dp[i-2] > dp[i-1]){
                dp[i] = preorder[i]+dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        
        return dp[dp.length-1];
    }
}
*/
