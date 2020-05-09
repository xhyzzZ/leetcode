// leetcode 1394 Find Lucky Integer in an Array

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (key == map.get(key)) list.add(key);
        }
        int res = 0;
        if (list.size() == 0) return -1;
        for (int x : list) {
            res = Math.max(res, x);
        }
        return res;
    }
}