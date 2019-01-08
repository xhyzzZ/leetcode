//leetcode 95 Unique Binary Search Trees II


/*
time: O(n)
space: O()
*/
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] res = new List[n + 1];
        res[0] = new ArrayList<>();
        if(n == 0) return res[0];
        res[0].add(null);
        for(int i = 1; i <= n; i++) {
        	res[i] = new ArrayList<>();
        	for(j = 0; j < i; j++) {
        		for(TreeNode left : res[j]) {
        			for(TreeNode root: res[i - j - 1]) {
        				TreeNode root = new TreeNode(j + 1);
        				root.left = left;
        				root.right = clone(right, i + 1);
        				res[i].add(root);
        			}
        		}
        	}
        }
        return res[n];
    }

    public TreeNode clone(TreeNode root, int k) {
    	if(root == null) return root;
    	TreeNode cur = new TreeNode(root.val + k);
    	cur.left = clone(root.left, k);
    	cur.right = clone(root.right, k);
    	return cur;
    }

  
/*
time: O()
space: O()
*/
    public List<TreeNode> generateTrees(int n) {
    	if(n == 0) return new ArrayList<>();
    	return genTreeList(1, n);
    }

    public List<TreeNode> genTreeList(int start, int end) {
    	List<TreeNode> list = new ArrayList<>();
    	if(start > end) {
    		list.add(null);
    	}
    	for(int idx = start; idx <= end; idx++) {
    		List<TreeNode> leftlist = genTreeList(start, idx - 1);
    		List<TreeNode> rightlist = genTreeList(idx + 1, end);
    		for(TreeNode left : leftlist) {
    			for(TreeNode right : rightlist) {
    				TreeNode root = new TreeNode(idx);
    				root.left = left;
    				root.right = right;
    				list.add(root);
    			}
    		}
    	}
    	return list;
    }
}