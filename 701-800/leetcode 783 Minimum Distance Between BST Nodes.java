//leetcode 783 Minimum Distance Between BST Nodes

/*
time: O(n)
space: O(h)
*/

class Solution {
    Integer res; 
    Integer prev;
        
    public int minDiffInBST(TreeNode root) {
        res = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return res;
    }
    
    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev !=  null){
            res = Math.min(res, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }
}