//leetcode 429 N-ary Tree Level Order Traversal

/*
time: O(n)
space: O(h)
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        	List<Integer> level = new ArrayList<>();
        	int len = queue.size();
        	for (int i = 0; i < len; i++) {
        		Node cur = queue.poll();
        		level.add(cur.val);
        		for (Node c : cur.children) {
        			queue.offer(c);
        		}
        	}
        	res.add(level);
        }
        return res;
    }
}