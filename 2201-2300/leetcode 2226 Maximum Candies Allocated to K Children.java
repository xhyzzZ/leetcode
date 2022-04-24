// leetcode 2226 Maximum Candies Allocated to K Children

/*
time: O(nlogn)
space: O(1)
*/

class Solution {
    public int maximumCandies(int[] candies, long k) {
        long left = 0, right = 0, sum = 0;
        for (int candy : candies) {
            left = Math.min(left, candy);
            right = Math.max(right, candy);
            sum += candy;
        }
        // mid = (left + right) / 2 to find first element valid
        // mid = (left + right + 1) / 2 to find last element valid
        
        if (sum < k) return 0;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            
            long pile = 0;
            for (int candy : candies) {
                pile += candy / mid;
            }
            
            if (k > pile) right = mid - 1;
            else left = mid;
        }
        return (int) left;
    }
}