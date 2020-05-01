//leetcode 687 Longest Univalue Path

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int longestUnivaluePath(TreeNode root) {
    	if(root == null) return 0;
        int[] res = new int[1];
        if (root != null) dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
    	// Longest-Univalue-Path-Start-At - left child
        int l = node.left != null ? dfs(node.left, res) : 0; 
        // Longest-Univalue-Path-Start-At - right child
        int r = node.right != null ? dfs(node.right, res) : 0; 
        // Longest-Univalue-Path-Start-At - node, and go left
        int resl = node.left != null && node.left.val == node.val ? l + 1 : 0; 
        // Longest-Univalue-Path-Start-At - node, and go right
        int resr = node.right != null && node.right.val == node.val ? r + 1 : 0; 
        // Longest-Univalue-Path-Across - node
        res[0] = Math.max(res[0], resl + resr); 
        return Math.max(resl, resr);
    }
}