// leetcode 1530 Number of Good Leaf Nodes Pairs

/*
time: O(n * D^2)
space: O(n)
*/


class Solution {
    private int res = 0, dist = 0;
    
    public int countPairs(TreeNode root, int distance) {
        dist = distance;
        helper(root);
        return res;
    }
    
    private int[] helper(TreeNode n) {
        int[] arr = new int[dist + 1];
        if (n == null)
            return arr;
        if (n.left == null && n.right == null) {
            arr[1] = 1;
            return arr;
        }
        int[] left = helper(n.left);
        int[] right = helper(n.right);
        
        for (int i = 1; i < dist; i++) { 
            for (int j = 1; j < dist; j++) {
                if (i + j <= dist) res += (left[i] * right[j]);
            }
        }
        
        for(int i = dist; i > 0; i--) {
            arr[i] += (left[i - 1] + right[i - 1]);
        }
        return arr;
    }
}