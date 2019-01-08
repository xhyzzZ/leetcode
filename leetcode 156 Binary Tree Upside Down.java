//leetcode 156 Binary Tree Upside Down


/*
time: O(n)
space: O(1)
*/
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        public TreeNode upsideDownBinaryTree(TreeNode root) {
		    TreeNode curr = root;
		    TreeNode next = null;
		    TreeNode temp = null;
		    TreeNode prev = null;
		    
		    while(curr != null) {
		        next = curr.left;
		        
		        // swapping nodes now, need temp to keep the previous right child
		        curr.left = temp;
		        temp = curr.right;
		        curr.right = prev;
		        
		        prev = curr;
		        curr = next;
		    }
		    return prev;
		}  
    }
}