class Solution {
    
    HashMap<TreeNode, TreeNode> parents = new HashMap(); //child to parent map
    
    public void traverse(TreeNode root, TreeNode parent){
        if(root==null) return;
        
        parents.put(root, parent);
        
        traverse(root.left, root);
        traverse(root.right, root);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        traverse(root, null);
        
        List<Integer> res = new LinkedList();
        
        HashSet<TreeNode> visited = new HashSet();
        Queue<TreeNode> q = new LinkedList();
        int level = 0;
        
        q.add(target);
        visited.add(target);
        
        while(!q.isEmpty()){
            
            if(level==K){
                while(!q.isEmpty()){
                    res.add(q.remove().val);
                }
                break;
            }
            
            int size = q.size();
            
            for(int i=0; i<size; i++){
                
                TreeNode first = q.remove();
                
                if(first.left!=null && !visited.contains(first.left)){
                    visited.add(first.left);
                    q.add(first.left);
                }
                
                if(first.right!=null && !visited.contains(first.right)){
                    visited.add(first.right);
                    q.add(first.right);
                }
                
                if(parents.containsKey(first)){
                    TreeNode parent = parents.get(first);
                    
                    if(parent!=null && !visited.contains(parent)) {
                        visited.add(parent);
                        q.add(parent);
                    }
                }
            }
            
            level++;
        }
        
        return res;
        
    }
}
