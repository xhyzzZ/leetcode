// leetcode 1769 Minimum Number of Operations to Move All Balls to Each Box

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = boxes.length();

        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];

        int count = boxes.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + count;
            count += boxes.charAt(i) - '0';
        }

        count = boxes.charAt(n - 1) - '0';
        for (int i = n - 2; i >=0; i--) {
            right[i] = right[i + 1] + count;
            count += boxes.charAt(i) - '0';
        }
        
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] + right[i];
        }

        return ans;
    }
}