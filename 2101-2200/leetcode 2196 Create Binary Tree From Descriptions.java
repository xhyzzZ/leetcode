// leetcode 2196 Create Binary Tree From Descriptions

/*
time: O(n)
space: O(n)
*/

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> children = new HashSet<>();
        Map<Integer, TreeNode> valToNode = new HashMap<>();
        for (int[] d : descriptions) {
            int parent = d[0], child = d[1], left = d[2];
            valToNode.putIfAbsent(parent, new TreeNode(parent));
            valToNode.putIfAbsent(child, new TreeNode(child));
            children.add(child);
            if (left == 1) {
                valToNode.get(parent).left = valToNode.get(child);
            }else {
                valToNode.get(parent).right = valToNode.get(child);
            }
        }
        valToNode.keySet().removeAll(children);
        return valToNode.values().iterator().next();
    }
}