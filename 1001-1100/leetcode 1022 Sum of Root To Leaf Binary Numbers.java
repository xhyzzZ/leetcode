// leetcode 1022 Sum of Root To Leaf Binary Numbers

/*
time: O(n)
space: O(h)
*/

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int prevSum) {
        if (root == null) return 0;
        prevSum = 2 * prevSum + root.val; 
        
        if (root.left == null && root.right == null) {
            return prevSum; //leaf node return the sum until root
        }
        return helper(root.left, prevSum) + helper(root.right, prevSum);
    }
}