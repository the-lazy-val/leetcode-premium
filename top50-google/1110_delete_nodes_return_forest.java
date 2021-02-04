/**
Naive solution: delete each node one by one
*/

class Solution {
    
    ArrayList<TreeNode> roots = new ArrayList();
    
    public boolean deleteNode(TreeNode root, int del){
        if(root==null) return false;
        if(root.val == del){
            if(root.left !=null) roots.add(root.left);
            if(root.right !=null) roots.add(root.right);
            roots.remove(root);
            return true;
        }else if(root.left!= null && root.left.val == del){
            TreeNode temp = root.left;
            
            root.left=null;
            
            if(temp.left !=null) roots.add(temp.left);
            if(temp.right !=null) roots.add(temp.right);
            return true;
        }else if(root.right!=null && root.right.val == del){
            TreeNode temp = root.right;
            
            root.right=null;
            
            if(temp.left !=null) roots.add(temp.left);
            if(temp.right !=null) roots.add(temp.right);
            return true;
        }else{
            return deleteNode(root.left, del) || deleteNode(root.right, del);
        }
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        roots.add(root);
        for(int del : to_delete){
            for(TreeNode r : roots){
                if(deleteNode(r, del)) break;
            }
        }
        
        return roots;
    }
}


/**
Better solution:
start deleting from leaves, and reshape tree as you go up
*/

public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        if (root == null) return forest;
        Set<Integer> set = new HashSet<>();
        for(int i : to_delete) {
            set.add(i);
        }
        deleteNodes(root, set, forest);
        if (!set.contains(root.val)) {
            forest.add(root);
        }
        return forest;
    }

    private TreeNode deleteNodes(TreeNode node, Set<Integer> set, List<TreeNode> forest) {
        if (node == null) return null;

        node.left = deleteNodes(node.left, set, forest);
        node.right = deleteNodes(node.right, set, forest);

        if (set.contains(node.val)) {
            if (node.left != null) forest.add(node.left);
            if (node.right != null) forest.add(node.right);
            return null;
        }

        return node;
    }
