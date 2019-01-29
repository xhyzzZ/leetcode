//leetcode 298 Binary Tree Longest Consecutive Sequence

/*
time: O(n)
space: O(h)
*/

class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
		return 0;
	}
    return DFS(root, root.val + 1, 1, 1);
}

	private int DFS(TreeNode node, int target, int curr, int max) {
		if (node == null) {
			return max;
		}
		if (node.val == target) {
			curr++;
			max = Math.max(max, curr);
		} else {
			curr = 1;
		}
		return Math.max(DFS(node.left, node.val + 1, curr, max), DFS(node.right, node.val + 1, curr, max));
    }
}