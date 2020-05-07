// leetcode 1343 Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int curr = 0, res = 0;
        for (int i = 0; i < k; i++) {
            curr += arr[i];  
        }
        
        if (curr / k >= threshold) res++;

        for (int j = k; j < arr.length; j++) { 
            curr = curr + arr[j] - arr[j - k]; 
            if (curr / k >= threshold) res++;     
        } 
        return res; 
    }
}