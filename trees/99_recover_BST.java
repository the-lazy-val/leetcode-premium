class Solution {
    
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack();
        
        TreeNode outOfPlaceNode = null;
        TreeNode swapCandidate = null;
        TreeNode prev = null;
        
        TreeNode curr = root;
        
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            
            curr = st.pop();
            
            //observe: inorder has ascending order for BST
            //so if curr.val < prev.val, that means we found an incorrect node
            
            //https://leetcode.com/problems/recover-binary-search-tree/solution/460724
            
            if(prev!=null && curr.val < prev.val){ 
                swapCandidate = curr;
                if(outOfPlaceNode==null) outOfPlaceNode=prev;
                else break;
            }
            
            prev=curr;
            curr=curr.right;
        }
        
        int temp = outOfPlaceNode.val;
        outOfPlaceNode.val = swapCandidate.val;
        swapCandidate.val=temp;
    }
}
