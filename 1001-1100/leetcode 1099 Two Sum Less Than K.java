// leetcode 1099 Two Sum Less Than K

/*
time: O(logn)
space: O(1)
*/

class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int low = 0, high = A.length - 1, maxSum = -1;
        Arrays.sort(A);
        while (low < high) {
            int sum = A[low] + A[high];
            if (sum < K) {
                maxSum = Math.max(sum, maxSum);
                low++;
            } else {
                high--;
            }
        }
        return maxSum;
    }
}