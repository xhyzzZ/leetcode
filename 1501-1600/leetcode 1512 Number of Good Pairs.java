// leetcode 1512 Number of Good Pairs

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            res += map.get(n) - 1;
        }
        return res;
    }
}