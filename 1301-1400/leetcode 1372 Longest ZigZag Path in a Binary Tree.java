// leetcode 1372 Longest ZigZag Path in a Binary Tree

/*
time: O(n)
space: O(h)
*/

class Solution {
    int res = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true);
        return res;
    }
    
    public int dfs(TreeNode node, boolean isLeft){
        if (node == null) return 0;
        int l = dfs(node.left, false);
        int r = dfs(node.right, true);
        res = Math.max(res, l);
        res = Math.max(res, r);
        //return sum for parent
        return 1 + (isLeft ? l : r);
    }
}