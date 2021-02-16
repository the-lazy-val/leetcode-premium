class Solution {
    
    public int getDepth(TreeNode root){
        int count=0;
        while(root.left!=null){ //why checking left? because question says all nodes in last level are as far left as possible
            count++;
            root=root.left;
        }
        
        return count;
    }
    
    public boolean nodeExists(TreeNode node, int depth, int idx){
        int left = 0;
        int right = (int)Math.pow(2, depth)-1;
        
        for(int d=0; d<depth; d++){
            
            int mid = (left+right)/2;
            
            if(idx <= mid){
                node=node.left;
                right=mid;
            }else{
                node=node.right;
                left=mid+1;
            }
        }
        
        return node!=null;
    }
    
    public int countNodes(TreeNode root) {
        
        if(root==null) return 0;
        
        int depth = getDepth(root);
        
        if(depth==0) return 1;
        
        //from depth we know, we atleast have all nodes till depth-1
        int total = (int)Math.pow(2, depth)-1;
        
        //Now we need to know how many nodes are on last level
        //since all nodes in last level are as far left as possible
        //and we know total nodes at any level is b/w 1 to 2^h, so we can do binary search on last level
        
        int left=0;
        int right=(int)Math.pow(2, depth)-1;
        
        while(left<=right){
            int mid = (left+right)/2; //assuming node exists at this index at last level
            
            if(nodeExists(root, depth, mid)){
                left=mid+1;
            }else{
                right=mid-1;
            }
            
        }
        
        return total + left;
    }
}
