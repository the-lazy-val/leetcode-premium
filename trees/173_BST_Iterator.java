class BSTIterator {
    
    Stack<TreeNode> st = new Stack();
    
    public void process(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        process(root);
    }
    
    public int next() {
        TreeNode curr = st.pop();
        if(curr.right!=null){
            process(curr.right);
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
