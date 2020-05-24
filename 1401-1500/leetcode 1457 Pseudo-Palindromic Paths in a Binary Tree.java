// leetcode 1457 Pseudo-Palindromic Paths in a Binary Tree

/*
time: O(n)
space: O(h)
*/

class Solution {
    List<String> per = new ArrayList<>();
    public int pseudoPalindromicPaths (TreeNode root) {
        printPaths(root, "");
        int count = 0;
        for (String p : per) {
            if (rearrange(p)) count++;
        }
        return count;
    }
    
    
    public void printPaths(TreeNode node, String path) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            per.add(path + node.val);
        } else {
            printPaths(node.left, path + node.val);
            printPaths(node.right, path + node.val);
        }
    }
    
    private boolean rearrange(String s) {
        
        int[] frequencyArr = createFrequencyArray(s);
        int oddCharCount = 0;
        for (int ch : frequencyArr) {
            if (ch % 2 != 0) oddCharCount++;
            if (oddCharCount > 1) return false;
        }
        return true;
    }
    
    private int[] createFrequencyArray(String s) {
        int[] frequencyArr = new int[256];
        char[] charArray = s.toCharArray();
        for (char ch : charArray) frequencyArr[ch]++;
        return frequencyArr;
    }
}