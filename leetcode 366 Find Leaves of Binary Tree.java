//leetcode 366 Find Leaves of Binary Tree

/*
time: O(n ^ 2)
space: O(h)
*/

class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leavesList = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        
        while (root != null) {
            if (isLeave(root, leaves)) root = null;
            leavesList.add(leaves);
            leaves = new ArrayList<>();
        }
        return leavesList;
    }
    
    public boolean isLeave(TreeNode node, List<Integer> leaves) {
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return true;
        }
        if (node.left != null) {
            if (isLeave(node.left, leaves)) node.left = null;
        }
        if (node.right != null) {
            if (isLeave(node.right, leaves)) node.right = null;
        }
        return false;
    }
}

/*
time: O(n)
space: O(h)
*/

public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }
    private int height(TreeNode node, List<List<Integer>> res) {
        if (node == null) return -1;
        int level = 1 + Math.max(height(node.left, res), height(node.right, res));
        if (res.size() < level + 1) res.add(new ArrayList<>());
        res.get(level).add(node.val);
        node.left = null;
        node.right = null;
        return level;
    }
}