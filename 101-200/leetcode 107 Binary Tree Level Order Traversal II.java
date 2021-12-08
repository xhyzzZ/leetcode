// leetcode 107 Binary Tree Level Order Traversal II

/*
time: O(n)
space: O(h)
*/

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        Collections.reverse(res);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode node, int level) {
        if (res.size() == level) res.add(new ArrayList<Integer>());

        // append the current node value
        res.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null) helper(res, node.left, level + 1);
        if (node.right != null) helper(res, node.right, level + 1);
    }
}