// leetcode 1817 Finding the Users Active Minutes

/*
time: O(n)
space: O(n)
*/


class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            map.putIfAbsent(log[0], new HashSet<>());
            map.get(log[0]).add(log[1]);
        }
        for (int key : map.keySet()) {
            res[map.get(key).size() - 1]++;
        }
        return res;
    }
}