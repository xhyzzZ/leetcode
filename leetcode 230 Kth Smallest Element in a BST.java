//leetcode 230 Kth Smallest Element in a BST

/*
time: O(n)
space: O(h)
*/

dfs
class Solution {
	private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    private void helper(TreeNode root) {
    	if (root.left != null) helper(root.left);
    	count--;
    	if (count == 0) {
    		number = root.val;
    		return;
    	}
    	if (root.right != null) helper(root.right);
    }
}

bfs
class Solution {
	public int kthSmallest(TreeNode root, int k) {
    	Stack<TreeNode> stack = new Stack<>();
      	while (root != null) {
        	stack.push(root);
        	root = root.left;
      	}   
      	while (k != 0) {
        	TreeNode n = stack.pop();
         	k--;
          	if (k == 0) return n.val;
          	TreeNode right = n.right;
          	while (right != null) {
            	stack.push(right);
            	right = right.left;
          	}
      	}
      	return -1; // never hit if k is valid
	}
}