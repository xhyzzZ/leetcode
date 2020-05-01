//leetcode 907 Sum of Subarray Minimums

/*
time: O()
space: O()
*/

class Solution {
    public int sumSubarrayMins(int[] A) {
        Stack<Integer> s = new Stack<>();
        int n = A.length, res = 0, mod = (int)1e9 + 7, j, k;
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[stack.peek()] > (i == n ? 0 : A[i])) {
                j = stack.pop();
                k = stack.isEmpty() ? -1 : stack.peek();
                res = (res + A[j] * (i - j) * (j - k)) % mod;
            }
            stack.push(i);
        }
        return res;
    }
}