// leetcode 1342 Number of Steps to Reduce a Number to Zero

/*
time: O(logn)
space: O(1)
*/

class Solution {
    public int numberOfSteps (int num) {
        int res = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                num -= 1;
                res++;
                if (num == 0) return res;
            } else {
                num /= 2;
                res++;
            }
        }
        return res;
    }
}