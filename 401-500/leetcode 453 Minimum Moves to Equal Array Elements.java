// leetcode 453 Minimum Moves to Equal Array Elements

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public int minMoves(int[] nums) {
        // adding 1 to all the elements except one is equivalent to decrementing 1 from a single element
        // find the number of decrement operations required to equalize all the elements of the given array
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i];
            min = Math.min(min, nums[i]);
        }
        return moves - min * nums.length;
    }
}
