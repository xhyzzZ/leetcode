//leetcode 617 Merge Two Binary Trees

/*
time: O()
space: O()
*/

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) return t1 == null ? t2 : t1;
        int val = t1.val + t2.val;
        TreeNode root = new TreeNode(val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}