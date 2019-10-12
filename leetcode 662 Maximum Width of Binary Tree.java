//leetcode 662 Maximum Width of Binary Tree

/*
time: O(n)
space: O(h)
*/
dfs
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        // left most nodes at each level;
        List<Integer> lefts = new ArrayList<Integer>(); 
        int[] res = new int[1]; // max width
        dfs(root, 1, 0, lefts, res);
        return res[0];
    }
    private void dfs(TreeNode node, int id, int depth, List<Integer> lefts, int[] res) {
        if (node == null) return;
        if (depth >= lefts.size()) lefts.add(id);   // add left most node
        res[0] = Integer.max(res[0], id + 1 - lefts.get(depth));
        dfs(node.left, id * 2, depth + 1, lefts, res);
        dfs(node.right, id * 2 + 1, depth + 1, lefts, res);
    }
}