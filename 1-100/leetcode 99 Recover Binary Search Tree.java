// leetcode 99 Recover Binary Search Tree

/*
time: O(n)
space: O(n)
*/

recursive
public class Solution {
	TreeNode first = null;
	TreeNode second = null;
	TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        helper(root);
        swap(first, second);
    }

    private void helper(TreeNode root) {
    	if (root == null) return;
    	helper(root.left);
    	if (prev != null && prev.val >= root.val) {
    		if (first == null) first = prev;
    		second = root;
    	}
    	prev = root;
    	helper(root.right);
    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}

/*
time: O(n)
space: O(n)
*/

iterative
class Solution {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pred = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) x = pred;
                else break;
            }
            pred = root;
            root = root.right;
        }
        swap(x, y);
    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}