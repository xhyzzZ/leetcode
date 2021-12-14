// leetcode 907 Sum of Subarray Minimums

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length, j, k;
        long res = 0, mod = (long) 1e9 + 7;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > (i == n ? 0 : arr[i])) {
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                res = (res + arr[j] * (i - j) * (j - k)) % mod;
            }
            stack.push(i);
        }
        return res;
    }
}