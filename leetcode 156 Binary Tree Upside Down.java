//leetcode 156 Binary Tree Upside Down


/*
time: O(n)
space: O(1)
*/

public class Solution {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		TreeNode newRoot = upsideDownBinaryTree(root.left);
		root.left.left = root.right; // node 2 left children
		root.left.right = root; // node 2 right children
		root.left = null;
		root.right = null;
		return newRoot;
	}
}

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
	    TreeNode curr = root;
	    TreeNode temp = null;
	    TreeNode prev = null;
	    
	    while (curr != null) {
	    	TreeNode next = curr.left;
			curr.left = temp;
			temp = curr.right;
			curr.right = prev;

			prev = curr;
			curr = next;
	    }
	    return prev;
    }
}

