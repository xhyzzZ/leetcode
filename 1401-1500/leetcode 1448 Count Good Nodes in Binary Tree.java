// leetcode 1448 Count Good Nodes in Binary Tree

/*
time: O(n)
space: O(h)
*/

class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }
    private void dfs(TreeNode node, int max) {
        if (node == null) return;
        if (node.val >= max) {
            count++;
            max = node.val;
        }
        dfs(node.left, max);
        dfs(node.right, max);
    }
}