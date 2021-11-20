// leetcode 623 Add One Row to Tree

/*
time: O(n)
space: O(h)
*/

bfs
public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (level < depth - 1) {
            Queue<TreeNode> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            queue = temp;
            level++;
        }
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }
        return root;
    }
}