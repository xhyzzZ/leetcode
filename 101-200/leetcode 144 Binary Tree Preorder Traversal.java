// leetcode 144 Binary Tree Preorder Traversal

/*
time: O(n)
space: O(h)
*/

recursive
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        helper(root, res);
        return pre;
    }

    public void helper(TreeNode root, List<Integer> res) {
    	if (root == null) return;
    	res.add(root.val);
    	helper(root.left, res);
    	helper(root.right, res);
    }
}

/*
time: O(n)
space: O(h)
*/

interative
class Solution {
    public List<Integer> preorderTraversal(TreeNode node) {
		List<Integer> res = new LinkedList<Integer>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode cur = stack.pop();
			res.add(cur.val);
			if (cur.right != null) stack.push(cur.right);
			if (cur.left != null) stack.push(cur.left);
		}
		return res;
	}
}