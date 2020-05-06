// leetcode 1315 Sum of Nodes with Even-Valued Grandparent

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int total = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
                if (cur.left.left != null && cur.val % 2 == 0) {
                    total += cur.left.left.val;      
                }                 
                if (cur.left.right != null && cur.val % 2 ==0) {
                    total += cur.left.right.val;          
                }                                
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                if (cur.right.left != null && cur.val % 2 == 0) {
                    total += cur.right.left.val;                
                }               
                           
                if (cur.right.right != null && cur.val % 2 == 0) {
                    total += cur.right.right.val;  
                }                                  
            }           
        }
        return total;
    }
}