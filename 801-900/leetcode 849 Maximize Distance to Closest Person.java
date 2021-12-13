// leetcode 849 Maximize Distance to Closest Person

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 0, len = seats.length, last = -1;
        for (int i = 0; i < len; i++) {
        	if (seats[i] == 1) {
        		res = last < 0 ? i : Math.max(res, (i - last) / 2);
        		last = i;
        	}
        }
        res = Math.max(res, len - last - 1);
        return res;
    }
}