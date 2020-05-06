// leetcode 1339 Maximum Product of Splitted Binary Tree

/*
time: O(n)
space: O(h)
*/

class Solution {
    long max = Integer.MIN_VALUE;
    int sum;
    public int maxProduct(TreeNode root) {
        if (root == null) return 0;
        int mod = 1000000007;
        sum = getSum(root);
        getMax(root);
        return (int) (max % (int) mod);
    }
    
    private int getSum(TreeNode root) {
    	if (root == null) return 0;
        return root.val + getSum(root.right) + getSum(root.left);
    }
    
    private long getMax(TreeNode root) {
    	if (root == null) return 0;
        long num = getMax(root.left) + getMax(root.right) + root.val;
        max = Math.max(max, num * (sum - num));
        return num;
    }
}