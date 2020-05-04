// leetcode 1288 Remove Covered Intervals

/*
time: O(nlogn)
space: O(1)
*/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int left = -1, right = -1;
        int res = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] in : intervals) {
            if (in[0] > left && in[1] > right) {
                left = in[0];
                res++;
            }
            right = Math.max(right, in[1]);
        }
        return res;
    }
}
