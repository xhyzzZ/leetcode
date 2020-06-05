// leetcode 1469 Find All the Lonely Nodes

/*
time: O(n)
space: O(h)
*/

class Solution {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }
    
    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right != null) list.add(node.right.val);
        if (node.left != null && node.right == null) list.add(node.left.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }
}