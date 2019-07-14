//leetcode 1038 Binary Search Tree to Greater Sum Tree

/*
time: O(n)
space: O(n)
*/

class Solution {
    public TreeNode bstToGst(TreeNode root) {
        Deque<TreeNode> stk = new ArrayDeque<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stk.isEmpty()) {
            while (cur != null) { // save right-most path of the current subtree
                stk.push(cur);
                cur = cur.right;
            }
            cur = stk.pop(); // pop out by reversed in-order.
            sum += cur.val; // update sum.
            cur.val = sum; // update node value.
            cur = cur.left; // move to left branch.
        }    
        return root;
    }
}