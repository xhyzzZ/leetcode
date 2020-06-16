// leetcode 1482 Minimum Number of Days to Make m Bouquets

/*
time: O(nlogmaxA)
space: O(1)
*/

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return -1;
        int min = 0, max = 0;
        for (int i : bloomDay) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        
        while (min < max) {
            int mid = min + (max - min) / 2;
            int bouq = getBouquet(bloomDay, mid, k);
            if (bouq < m) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
    
    private int getBouquet(int[] bloomDay, int day, int k) {
        int bouq = 0, flowers = 0;
        for (int val : bloomDay) {
            if (val <= day) {
                flowers++;
            } else {
                flowers = 0;
            }
            
            if (flowers == k) {
                bouq++;
                flowers = 0;
            }
        }
        return bouq;
    }
}