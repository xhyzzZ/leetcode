// leetcode 1506 Find Root of N-Ary Tree

/*
time: O(n)
space: O(1)
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        int sum = 0;
        for (Node node : tree) {
            sum += node.val;
        }

        for (Node node : tree) {
            for (Node child : node.children) {
                sum -= child.val;
            }
        }
        for (Node node : tree) {
            if (sum == node.val) return node;
        }
        return null;
    }
}