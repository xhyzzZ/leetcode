// leetcode 1228 Missing Number In Arithmetic Progression

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int missingNumber(int[] arr) {
        int len = arr.length;       // total length of the given array
        
        int sum = 0;                // the sum of the given array
        int totalSum = (arr[0] + arr[len - 1]) * (len + 1) / 2; // the actual sum from the start to the end
        
        for (int i = 0; i < len; ++i) {
            sum += arr[i];
        }
        
        // return the difference
        return totalSum - sum;
    }
}