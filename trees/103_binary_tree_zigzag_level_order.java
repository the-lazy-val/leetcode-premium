class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root==null) return new LinkedList();
        
        List<List<Integer>> res = new LinkedList();
        
        Queue<TreeNode> q = new LinkedList();
        
        q.add(root);
        
        int level=0;
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList();
            
            for(int i=0; i<size; i++){
                TreeNode front = q.remove();
                
                if(front.left!=null) q.add(front.left);
                if(front.right!=null) q.add(front.right);
                
                li.add(front.val);
            }
            
            if(level%2==0){
                res.add(li);
            }else{
                Collections.reverse(li);
                res.add(li);
            }
            
            level++;
        }
        
        return res;
    }
}
