//leetcode 107 Binary Tree Level Order Traversal II


/*
time: O(n)
space: O(n)
*/

//DFS solution:
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 1);
        return res;
    }

    public void helper(List<List<Integer>> list, TreeNode root, int level) {
    	if(root == null) return;
    	if(level > list.size()) {
    		list.add(0, new ArrayList<Integer>());
    	}
    	helper(list, root.left, level + 1);
    	helper(list, root.right, level + 1);
    	list.get(list.size() - level).add(root.val);
    }
}