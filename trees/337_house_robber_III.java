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
