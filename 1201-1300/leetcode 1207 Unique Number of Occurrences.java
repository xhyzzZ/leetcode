// leetcode 1207 Unique Number of Occurrences

/*
time: O(n)
space: O(n)
*/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (!set.add(map.get(key))) return false;
        }
        return true;
    }
}