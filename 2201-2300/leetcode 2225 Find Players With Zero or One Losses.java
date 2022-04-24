// leetcode 2225 Find Players With Zero or One Losses

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses = new TreeMap<>();
        for (int[] m : matches) {
            losses.put(m[0], losses.getOrDefault(m[0], 0));
            losses.put(m[1], losses.getOrDefault(m[1], 0) + 1);
        }
        List<List<Integer>> res = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (int player : losses.keySet()) {
            if (losses.get(player) <= 1) res.get(losses.get(player)).add(player);
        }
        return res;
    }
}