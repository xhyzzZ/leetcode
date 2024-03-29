// leetcode 915 Partition Array into Disjoint Intervals

/*
time: O(n)
space: O(1)

suppose the original left subarray is from 0 to partitionIdx, 
the max value of that is localMax. If it is a valid partition, 
every value from partitionIdx + 1 to end should be >= localMax. 
But if we find a value in the right part, a[i], is smaller than localMax, 
which means the partition is not correct and we have 
to incorporate a[i] to form the left subarray. So the partitionIdx is set to be i, 
and we have to recalculate the max value of the new left subarray.(recorded in max)
*/

class Solution {
    public int partitionDisjoint(int[] nums) {
        int currMax = nums[0];
        int possibleMax = nums[0];
        int length = 1;
        
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < currMax) {
                length = i + 1;
                currMax = possibleMax;
            } else {
                possibleMax = Math.max(possibleMax, nums[i]);
            }
        }
        
        return length;
    }
}