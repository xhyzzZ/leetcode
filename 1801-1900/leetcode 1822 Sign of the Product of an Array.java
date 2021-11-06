// leetcode 1822 Sign of the Product of an Array

/*
time: O(n)
space: O(1)
*/


class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int i : nums) {
            if (i == 0) return 0;
            if (i < 0) sign *= -1;
        }
        return sign;
    }
}