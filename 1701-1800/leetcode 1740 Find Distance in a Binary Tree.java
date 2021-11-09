// leetcode 1740 Find Distance in a Binary Tree

/*
time: O(n)
space: O(1)
*/


class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode ancestor = findAncestor(root, p, q);
        int ancestor_level = -1, p_level = -1, q_level = -1;
        int level = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == ancestor.val) ancestor_level = level;
                if (cur.val == p) p_level = level;
                if (cur.val == q) q_level = level;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            level += 1;
        }
        return  p_level + q_level - 2 * ancestor_level;
    }

    private TreeNode findAncestor(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        TreeNode left = findAncestor(root.left, p, q);
        TreeNode right = findAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else if (left != null) return left;
        else if (right != null) return right;
        else return null;
    }
}