class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode candidate = null;
        TreeNode cur = root;

        while (cur != null) {
            if (p.val < cur.val) {
                candidate = cur;
                cur = cur.left;
            } else {
                // p.val >= cur.val
                cur = cur.right;
            }
        }

        return candidate;
    }
}
