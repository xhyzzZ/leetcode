// leetcode 513 Find Bottom Left Tree Value

/*
time: O(n)
space: O(h)
*/

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        root = queue.poll();
	        if (root.right != null) {
	            queue.add(root.right);
            }
	        if (root.left != null) {
	            queue.add(root.left);
            }
	    }
	    return root.val;
    }
}

public class Solution {
    int maxDepth = 0;
    int val = 0;

    private void dfs(TreeNode root, int depth) {
        if (root != null) {
            if (depth > maxDepth) {
                val = root.val;
                maxDepth = depth;
            }
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return val;
    }
}