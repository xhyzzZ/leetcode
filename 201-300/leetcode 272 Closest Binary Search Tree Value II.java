// leetcode 272 Closest Binary Search Tree Value II

/*
time: O(n)
space: O(k)
*/

public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> deque = new LinkedList<>();
        inorder(deque, root, target, k);
        return new ArrayList(deque);
    }
    
    private void inorder(Deque<Integer> deque, TreeNode root, double target, int k) {
        if (root == null) return;
        inorder(deque, root.left, target, k);
        
        if (deque.size() == k) {
            if (Math.abs(deque.getFirst() - target) < Math.abs(root.val - target)) {
                return;
            } else {
                deque.removeFirst();
            }
        }
        
        deque.addLast(root.val);
        inorder(deque, root.right, target, k);
    }
}

/*
time: O(logn + k)
space: O(logn)
*/

public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new LinkedList<Integer>();
        // populate the predecessor and successor stacks 
        Stack<TreeNode> pred = new Stack<TreeNode>();
        Stack<TreeNode> succ = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null) {
            if (target <= curr.val) {
                succ.push(curr);
                curr = curr.left;
            } else {
                pred.push(curr);
                curr = curr.right;
            }
        }
        while (k > 0) {
            if (pred.empty() && succ.empty()) {
                break; 
            } else if (pred.empty()) {
                result.add(getSuccessor(succ));
            } else if (succ.empty()) {
                result.add(getPredecessor(pred));
            } else if (Math.abs(target - pred.peek().val) < Math.abs(target - succ.peek().val)) {
                result.add(getPredecessor(pred));                    
            } else {
                result.add(getSuccessor(succ));
            }
            k--;
        }
        return result;
     }

    private int getPredecessor(Stack<TreeNode> st) {
        TreeNode popped = st.pop();
        TreeNode p = popped.left;
        while (p != null) {
            st.push(p);
            p = p.right;
        }
        return popped.val;
    }

    private int getSuccessor(Stack<TreeNode> st) {
        TreeNode popped = st.pop();
        TreeNode p = popped.right;
        while (p != null) {
            st.push(p);
            p = p.left;
        }
        return popped.val;
    }
}