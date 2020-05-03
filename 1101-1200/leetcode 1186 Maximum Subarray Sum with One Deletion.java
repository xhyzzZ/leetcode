// leetcode 1186 Maximum Subarray Sum with One Deletion

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int maximumSum(int[] arr) {
        int sum = arr[0];
        int max = arr[0];
        int skip = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = sum;
            sum += arr[i];
            sum = Math.max(sum, arr[i]);
            
            skip = Math.max(temp, skip + arr[i]);
            
            temp = Math.max(sum, skip);
            
            max = Math.max(temp, max);
         }
         return max;
    }
}