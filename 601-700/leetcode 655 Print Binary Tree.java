// leetcode 655 Print Binary Tree

/*
time: O(n^2)
space: O(n^2)
*/

class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = height(root);
        int len = (int) Math.pow(2, height) - 1;
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < len; j++) temp.add("");
            list.add(new ArrayList(temp));
        }
        setTree(list, root, 0, len - 1, height, 0);
        return list;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private void setTree(List<List<String>> list, TreeNode root, int left, int right, int height, int level) {
        if (height == level || root == null) return;
        int mid = left + (right - left) / 2; //    Here is the mid
        list.get(level).set(mid, String.valueOf(root.val));
        setTree(list, root.left, left, mid - 1, height, level + 1);
        setTree(list, root.right, mid + 1, right, height, level + 1);
    }
}