public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "X,";
        
        String leftSubTree = serialize(root.left);
        String rightSubTree = serialize(root.right);
        
        return root.val + "," + leftSubTree + rightSubTree;
    }
    
    public TreeNode deserializeHelper(Queue<String> nodesLeft){
        String curr = nodesLeft.poll();
        
        if(curr.equals("X")) return null;
        
        TreeNode newNode = new TreeNode(Integer.valueOf(curr));
        
        newNode.left = deserializeHelper(nodesLeft);
        newNode.right = deserializeHelper(nodesLeft);
        
        return newNode;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodesLeft = new LinkedList();
        nodesLeft.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodesLeft);
    }
}
