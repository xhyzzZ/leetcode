//leetcode 272 Closest Binary Search Tree Value II

/*
time: O(n)
space: O(h)
*/

public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        collect(root, target, k, res);
        return res;
    }

    public void collect(TreeNode root, double target, int k, LinkedList<Integer> res) {
        if (root == null) return;
        collect(root.left, target, k, res);

        if (res.size() == k) {
            //if size k, add curent and remove head if it's optimal, otherwise return
            if (Math.abs(target - root.val) < Math.abs(target - res.peekFirst())) 
                res.removeFirst();
            else return;
        }
        res.add(root.val);
        collect(root.right, target, k, res);
    }
}