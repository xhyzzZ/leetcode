// leetcode 2007 Find Original Array From Doubled Array

/*
time: O(n + klogk)
space: O(n)
*/

class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length, i = 0;
        if (n % 2 == 1) return new int[0];
        int[] res = new int[n / 2];
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : changed)
            count.put(a, count.getOrDefault(a, 0) + 1);
        List<Integer> keys = new ArrayList<>(count.keySet());
        Collections.sort(keys);
        for (int x : keys) {
            if (count.get(x) > count.getOrDefault(x + x, 0))
                return new int[0];
            for (int j = 0; j < count.get(x); j++) {
                res[i++] = x;
                count.put(x + x, count.get(x + x) - 1);
            }
        }
        return res;
    }
}