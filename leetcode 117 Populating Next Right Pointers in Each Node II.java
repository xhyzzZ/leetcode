//leetcode 117 Populating Next Right Pointers in Each Node II


/*
time: O(n)
space: O(1)
*/
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        // - - - - - - - - - - - - - - - - - 
        // 每一层 层序遍历建立链表
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
        // - - - - - - - - - - - - - - - - - -  
            root = root.next;

        // root为空，则重建dummyHead 
            if (root == null) {
                pre = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
    }
}