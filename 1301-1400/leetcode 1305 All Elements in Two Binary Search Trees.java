// leetcode 1305 All Elements in Two Binary Search Trees

/*
time: O(n)
space: O(n)
*/

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        inorder(root1, ans);
        inorder(root2, ans);
        Collections.sort(ans); // Here it calls List.sort(object) method.
        return ans;
    }
    private void inorder(TreeNode n, List<Integer> ans) {
        if (n == null) return;
        inorder(n.left, ans);
        ans.add(n.val);
        inorder(n.right, ans);
    }
}