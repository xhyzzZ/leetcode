// leetcode 2187 Minimum Time to Complete Trips

/*
time: O(n)
space: O(1)
*/

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long min = time[0];
        for (int x : time) {
            min = Math.min(min, x);
        }
        
        long start = min;
        long end = min * totalTrips;
        
        while (start < end) {
            long mid = start + (end - start) / 2;
            if (valid(mid, time, totalTrips)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return (long) start;
    }
    
    private boolean valid(long mid, int[] time, int totalTrips) {
        long trip = 0;
        for (int x : time) {
            trip += mid / x;
        } 
        
        return trip >= totalTrips;
    }
}