// leetcode 1015 Smallest Integer Divisible by K

/*
time: O(k)
space: O(1)
*/

class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int remainder = 0;
        for (int n = 1; n <= k; n++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) return n;
        }
        return -1;
    }
}