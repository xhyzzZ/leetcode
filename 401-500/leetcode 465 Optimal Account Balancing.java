// leetcode 465 Optimal Account Balancing

/*
time: O()
space: O()
*/

class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }
        return settle(0, new ArrayList<>(map.values()));
    }

    private int settle(int start, List<Integer> debt) {
        while (start < debt.size() && debt.get(start) == 0) start++;
        if (start == debt.size()) return 0;
        int res = Integer.MAX_VALUE;
        for (int i = start + 1; i < debt.size(); i++) {
        	if (debt.get(start) * debt.get(i) < 0) {
                debt.set(i, debt.get(i) + debt.get(start));
                res = Math.min(res, 1 + settle(start + 1, debt));
                debt.set(i, debt.get(i) - debt.get(start));
            }
        }   
        return res;
    }
}