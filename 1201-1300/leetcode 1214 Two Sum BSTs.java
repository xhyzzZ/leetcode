// leetcode 1214 Two Sum BSTs

/*
time: O(n)
space: O(h)
*/

class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        // if either of the tree is empty
        if (root1 == null || root2 == null)
            return false;
        // stack 'stack1' used for the inorde traversal of root 1
        // stack 'stack2' used for the reverse inorder traversal of root 2
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode t1, t2;
        while (true) {
            // LeftMost Node.
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            // RighMost Node.
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.right;
            }
            // If either is empty then break.
            if (stack1.empty() || stack2.empty()) break;

            t1 = stack1.peek();
            t2 = stack2.peek();

            // if the sum of the node's is equal to 'target'
            if ((t1.val + t2.val) == target) {
                return true;
            } else if ((t1.val + t2.val) < target) {
                // move to next possible node in the inorder traversal of root 1
                stack1.pop();
                root1 = t1.right;
            } else {
                // move to next possible node in the reverse inorder traversal of root 2
                stack2.pop();
                root2 = t2.left;
            }
        }
        return false;
    }
}
