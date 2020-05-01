//leetcode 172 Factorial Trailing Zeroes


/*
time: O(logn)
space: O()
*/
public class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}