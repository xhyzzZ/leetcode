//leetcode 366 Find Leaves of Binary Tree

/*
time: O(n ^ 2)
space: O(h)
*/

class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leavesList = new ArrayList<List<Integer>>();
        List<Integer> leaves = new ArrayList<Integer>();
        
        while(root != null) {
            if(isLeave(root, leaves)) root = null;
            leavesList.add(leaves);
            leaves = new ArrayList<Integer>();
        }
        return leavesList;
    }
    
    public boolean isLeave(TreeNode node, List<Integer> leaves) {
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return true;
        }
        if (node.left != null) {
             if(isLeave(node.left, leaves))  node.left = null;
        }
        if (node.right != null) {
             if(isLeave(node.right, leaves)) node.right = null;
        }
        return false;
    }
}