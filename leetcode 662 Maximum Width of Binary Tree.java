//leetcode 662 Maximum Width of Binary Tree

/*
time: O()
space: O()
*/
dfs
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> lefts = new ArrayList<Integer>(); // left most nodes at each level;
        return dfs(root, 1, 0, lefts);
    }

    private int dfs(TreeNode n, int id, int d, List<Integer> lefts) { // d : depth
        if (n == null) return 0;
        if (d >= lefts.size()) lefts.add(id);   // add left most node
        return Math.max(id + 1 - lefts.get(d), 
        	   Math.max(dfs(n.left, id * 2, d + 1, lefts), dfs(n.right, id * 2 + 1, d + 1, lefts)));
    }
}