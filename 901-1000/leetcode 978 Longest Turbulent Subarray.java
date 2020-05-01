//leetcode 978 Longest Turbulent Subarray

/*
time: O(n)
space: O(1)
For each A[i]
inc: The length of current valid sequence which ends with two increasing numbers
dec: The length of current valid sequence which ends with two decreasing numbers
*/

class Solution {
    public int maxTurbulenceSize(int[] A) {
        int inc = 1, dec = 1, result = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                dec = inc + 1;
                inc = 1;
            } else if (A[i] > A[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            result = Math.max(result, Math.max(dec, inc));
        }
        return result;
    }
}