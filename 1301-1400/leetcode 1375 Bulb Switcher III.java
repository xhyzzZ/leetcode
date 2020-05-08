// leetcode 1375 Bulb Switcher III

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int numTimesAllBlue(int[] light) {
        int right = 0, res = 0, n = light.length;
        for (int i = 0; i < n; ++i) {
            right = Math.max(right, light[i]);
            if (right == i + 1) res++;
        }
        return res;
    }
}