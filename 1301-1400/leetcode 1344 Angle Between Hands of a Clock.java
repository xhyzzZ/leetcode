// leetcode 1344 Angle Between Hands of a Clock

/*
time: O()
space: O()
*/

class Solution {
    public double angleClock(int hour, int minutes) {
		double res = Math.abs(60 * hour - 11 * minutes) / 2.0;
        if (res > 180) {
            res = 360 - res;
        }
        
        return res;
    }
}