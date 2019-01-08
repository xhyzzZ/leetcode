//leetcode 106 Construct Binary Tree from Inorder and Postorder Traversal


/*
time: O(n)
space: O(n)
*/
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
       		inMap.put(inorder[i], i);
        } 
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder, inMap);
    }

    private TreeNode helper(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder, HashMap<Integer, Integer> inMap) {
    	if(postEnd < 0 || inStart > inEnd) return null;
    	TreeNode root = new TreeNode(postorder[postEnd]);
    	int inIndex = inMap.get(root.val);
    	root.left = helper(postEnd - (inEnd - inIndex + 1), inStart, inIndex - 1, inorder, postorder, inMap);
    	root.right = helper(postEnd - 1, inIndex + 1, inEnd, inorder, postorder, inMap);
    	return root;
    }
}