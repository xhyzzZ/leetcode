// leetcode 1423 Maximum Points You Can Obtain from Cards

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int total = 0;
        int cur = 0, start = 0, end = 0, min = Integer.MAX_VALUE;
        while (end < len) {
            total += cardPoints[end];
            cur += cardPoints[end];
            if (end - start + 1 == len - k) {
                min = Math.min(min, cur);
                cur -= cardPoints[start];
                start++;
            }
            end++;
        }
        
        return total - (min == Integer.MAX_VALUE ? 0 : min);
    }
}