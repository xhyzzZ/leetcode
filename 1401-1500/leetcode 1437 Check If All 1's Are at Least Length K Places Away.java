// leetcode 1437 Check If All 1's Are at Least Length K Places Away

/*
time: O(n)
space: O(1)
*/

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (index != -1 && i - index - 1 < k) return false;
                index = i;
            }
        }
        return true;
    }
}