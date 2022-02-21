// leetcode 668 Kth Smallest Number in Multiplication Table

/*
time: O(m∗log(m∗n))
space: O(1)
*/

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (!enough(mid, m, n, k)) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }
}