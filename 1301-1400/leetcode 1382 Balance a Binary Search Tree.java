// leetcode 1382 Balance a Binary Search Tree

/*
time: O(n)
space: O(h + n)
*/

class Solution {
    List<TreeNode> sortedArr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return sortedArrayToBST(0, sortedArr.size() - 1);
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        sortedArr.add(root);
        inorder(root.right);
    }
    private TreeNode sortedArrayToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = sortedArr.get(mid);
        root.left = sortedArrayToBST(start, mid - 1);
        root.right = sortedArrayToBST(mid + 1, end);
        return root;
    }
}