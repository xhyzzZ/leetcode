// leetcode 1503 Last Moment Before All Ants Fall Out of a Plank

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        for (int i : left) res = Math.max(res, i);
        for (int i : right) res = Math.max(res, n - i);
        return res;
    }
}