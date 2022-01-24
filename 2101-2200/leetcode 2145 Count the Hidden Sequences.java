// leetcode 2145 Count the Hidden Sequences

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long first = 0, max = 0, min = 0;
        for (int d : differences) {
            first += d;
            max = Math.max(max, first);
            min = Math.min(min, first);
        }
        return (int) Math.max(0, (upper - lower) - (max - min) + 1);
    }
}
