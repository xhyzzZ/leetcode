//leetcode 965 Univalued Binary Tree

/*
time: O(n)
space: O(h)
*/

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root.left != null) {
            if (!isUnivalTree(root.left))
                return false;
            if (root.left.val != root.val)
                return false;
        }

        if (root.right != null) {
            if (!isUnivalTree(root.right))
                return false;
            if (root.right.val != root.val)
                return false;
        }
        return true;
    }
}