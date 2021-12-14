// leetcode 1010 Pairs of Songs With Total Durations Divisible by 60

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int reducedTime = t % 60;
            int other = (reducedTime == 0) ? 0 : 60 - reducedTime;
            ans += count.getOrDefault(other, 0);
            count.put(reducedTime, count.getOrDefault(reducedTime, 0) + 1);
        }
        return ans;
    }
}