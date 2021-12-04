// leetcode 106 Construct Binary Tree from Inorder and Postorder Traversal

/*
time: O(n)
space: O(h)
*/

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] inorder, int[] postorder, int index, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd || index < 0) return null;
        int rootVal = postorder[index];
        int pos = inorderStart;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootVal) {
                pos = i;
                break;
            }
        }
        int rightSubtreeLength = inorderEnd - pos;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, postorder, index - rightSubtreeLength - 1, inorderStart, pos - 1);
        root.right = build(inorder, postorder, index - 1, pos + 1, inorderEnd);
        return root;
    }
}