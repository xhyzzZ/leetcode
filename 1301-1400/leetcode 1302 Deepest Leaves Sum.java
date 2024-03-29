// leetcode 1302 Deepest Leaves Sum

/*
time: O(n)
space: O(h)
*/

bfs
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0; // Reset for calculating the sum of elements of the next level
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                sum += top.val;
                if (top.left != null) queue.offer(top.left);
                if (top.right != null) queue.offer(top.right);
            }
        }
        return sum;
    }
}

/*
time: O(n)
space: O(h)
*/

dfs
class Solution {
     public int deepestLeavesSum(TreeNode root) {
        int maxDepth = depth(root);
        int[] res = {0};
        findSum(root, maxDepth, 1, res);
        return res[0];
    }

    private void findSum(TreeNode root, int maxDepth, int currentDepth, int[] res) {
        if (root == null) return;
        if (currentDepth == maxDepth) {
            res[0] += root.val;
        }
        findSum(root.left, maxDepth, currentDepth + 1, res);
        findSum(root.right, maxDepth, currentDepth + 1, res);
    }
    
    private int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}