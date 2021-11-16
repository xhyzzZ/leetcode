// leetcode 1302 Deepest Leaves Sum

/*
time: O(n)
space: O(h)
*/

bfs
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            sum = 0; // Reset for calculating the sum of elements of the next level
            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();
                sum += top.val;
                if (top.left != null) q.offer(top.left);
                if (top.right != null) q.offer(top.right);
            }
        }
        return sum;
    }
}

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