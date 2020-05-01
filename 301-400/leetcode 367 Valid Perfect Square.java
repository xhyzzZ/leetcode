// leetcode 367 Valid Perfect Square

/*
time: O(logn)
space: O(1)
*/

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;
        int left = 1, right = num;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > num / mid) {
                right = mid - 1;
            } else if (mid < num / mid) {
                left = mid + 1;
            } else {
                return num % mid == 0;
            }
        }
        return false;
    }
}