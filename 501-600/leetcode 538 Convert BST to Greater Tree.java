//leetcode 538 Convert BST to Greater Tree

/*
time: O(n)
space: O(1)
*/

class Solution {
    public TreeNode convertBST(TreeNode root) {
        helper(root, 0);
        return root;
    }
    private int helper(TreeNode node, int sum) {
        if (node == null) return sum;
        node.val += helper(node.right, sum);
        return helper(node.left, node.val);
    }
}