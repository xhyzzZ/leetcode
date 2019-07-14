//leetcode 1014 Best Sightseeing Pair

/*
time: O(n)
space: O(1)
The goal is to keep track of:

Maximum So far and add it to the cur_cell and maintain maximum result
Here, max_so_far contains : A[i] + i
Original Given Formula : A[i] + A[j] + i - j

Break in two parts : A[i] + i and A[j] -j
Keep MAX_VALUE of first part among the elements seen so far
Add the current element to max_so_far and check the result is changing or not
Also, keep updating the max_so_far at each step
*/

class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int max_so_far = A[0];
        int result = 0;
        for (int i = 1; i < A.length; i++) {
            result = Math.max(result, max_so_far + A[i] - i);
            max_so_far = Math.max(max_so_far, A[i] + i);
        }   
        return result;
    }
}