// leetcode 671 Second Minimum Node In a Binary Tree

/*
time: O(n)
space: O(h)
*/

// idea: 
// 1. stop recurse when curRoot.val > min (problem property)
// 2. child reports its min to parent

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
	    if (root == null) return -1;
	    return helper(root, root.val);
	}


	public int helper(TreeNode root, int min) {
		// recursive function returns the smallest int greater than "min" in this tree
		// returns -1 otherwise (child reports)
	    if (root == null) return -1;
	    // min of subtree > min of parent tree => 
	    // report this potential second min to parent 
	    if (root.val > min) return root.val;
	    int leftMin = helper(root.left, min);
	    int rightMin = helper(root.right, min);
	    // return minimum(leftMin,rightMin) if no -1
	    return (leftMin == -1 || rightMin == -1) ? 
	    	Math.max(leftMin, rightMin) : Math.min(leftMin, rightMin);
	}
}