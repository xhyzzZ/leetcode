// leetcode 1295 Find Numbers with Even Number of Digits

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int findNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        for (int num : nums) {
            int len = String.valueOf(num).length();
            if (len % 2 == 0) sum++;
        }
        return sum;
    }
}