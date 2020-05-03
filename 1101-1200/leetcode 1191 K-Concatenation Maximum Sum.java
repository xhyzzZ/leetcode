// leetcode 1191 K-Concatenation Maximum Sum

/*
time: O(n)
*/

class Solution {
    int mod = 1000000000 + 7;

    private int maxSubArray(int[] arr, int repeat) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < repeat * arr.length; i++) {
            int n = arr[i % arr.length];
            sum = Math.max(sum + n, n);
            max = Math.max(max, sum);
        }
        return max;
    }

    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;
        for (int n : arr)
            sum += n;
        if (k == 1) return maxSubArray(arr, 1);
        if (k == 2 || sum <= 0) return maxSubArray(arr, 2);
        return Math.toIntExact(((k - 2) * (sum % mod) + maxSubArray(arr, 2)) % mod);
    }
}