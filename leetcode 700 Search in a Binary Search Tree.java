//leetcode 700 Search in a Binary Search Tree

/*
time: O(n)
space: O(h)
*/

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
        return val < root.val? searchBST(root.left, val): searchBST(root.right, val);
    }
}