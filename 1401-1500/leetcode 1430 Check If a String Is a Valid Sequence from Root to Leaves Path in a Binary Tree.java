// leetcode 1430 Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree

/*
time: O(n)
space: O(h)
*/

class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }
    
    private boolean dfs(TreeNode node, int[] arr, int depth) {
        if (node == null || depth >= arr.length || arr[depth] != node.val) {
            return false;
        }
        // key base case: a leave found.
        if (node.left == null && node.right == null) {
            // valid sequence?
            return depth + 1 == arr.length; 
        }
        return dfs(node.left, arr, depth + 1) || dfs(node.right, arr, depth + 1);
    }
}