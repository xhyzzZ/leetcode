// leetcode 1109 Corporate Flight Bookings

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] v : bookings) {
            res[v[0] - 1] += v[2];
            if (v[1] < n) res[v[1]] -= v[2];
        }
        for (int i = 1; i < n; ++i) res[i] += res[i - 1];
        return res;
    }
}