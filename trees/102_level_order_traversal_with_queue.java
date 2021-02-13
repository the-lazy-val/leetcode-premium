class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        
        List<List<Integer>> res = new LinkedList();
        
        if(root!=null) q.add(root);
        
        TreeNode curr;
        
        while(!q.isEmpty()){
            int currSize = q.size();
            
            List<Integer> thisLevel = new LinkedList();
                
            for(int i=0; i<currSize; i++){
                curr = q.poll();
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                
                thisLevel.add(curr.val);
            }
            res.add(thisLevel);
        }
        
        return res;
    }
}
