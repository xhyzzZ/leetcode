// leetcode 1602 Find Nearest Right Node in Binary Tree

/*
time: O(n)
space: O(h)
*/

bfs
class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null) return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur == u) {
                    if (i == size - 1) {
                        return null;
                    } else {
                        return q.poll();
                    }
                }                
                if (cur.left != null) {
                    q.add(cur.left);
                }                
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
        return null;
    }
}