//leetcode 662 Maximum Width of Binary Tree

/*
time: O(n)
space: O(h)
*/
dfs
class Solution {
    private int max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        List<Integer> startOfLevel = new ArrayList<>();
        helper(root, 0, 1, startOfLevel);
        return max;
    }
    public void helper(TreeNode root, int level, int index, List<Integer> list) {
        if (root == null) return;
        if (level == list.size()) list.add(index);
        max = Math.max(max, index + 1 - list.get(level));
        helper(root.left, level + 1, index * 2, list);
        helper(root.right, level + 1, index * 2 + 1, list);
    }
}

bfs
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        root.val = 0;
        int max = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            max = Math.max(max, q.peekLast().val - q.peekFirst().val + 1);
            for (int i = 0; i < size; i++) {
                root = q.poll();
                if (root.left != null) {
                    root.left.val = root.val * 2;
                    q.offer(root.left);
                }
                if (root.right != null) {
                    root.right.val = root.val * 2 + 1;
                    q.offer(root.right);
                }
            }
        }
        return max;
    }
}