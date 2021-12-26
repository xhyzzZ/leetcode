// leetcode 2096 Step-By-Step Directions From a Binary Tree Node to Another

/*
time: O(n)
space: O(n)
*/

class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = lowestCommonAncestor(root, startValue, destValue);
        StringBuilder sb = new StringBuilder();
        
        addDirection(lca, startValue, true, sb);
        addDirection(lca, destValue, false, sb);
        
        return sb.toString();

    }

    private boolean addDirection(TreeNode node, int val, boolean isStart, StringBuilder sb) {
        if (node == null) return false;
        if (node.val == val) return true;
        
        sb.append(isStart ? 'U' : 'L');
        if (addDirection(node.left, val, isStart, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);
        
        sb.append(isStart ? 'U' : 'R');
        if (addDirection(node.right, val, isStart, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);
        
        return false;
    }

    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || p == root.val || q == root.val) return root; 
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root; 
        else return left == null ? right : left;
    }
}