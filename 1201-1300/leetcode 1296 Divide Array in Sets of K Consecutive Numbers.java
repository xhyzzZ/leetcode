// leetcode 1296 Divide Array in Sets of K Consecutive Numbers

/*
time: O(N+MlogM)
space: O(n)
*/

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        Queue<Integer> start = new LinkedList<>();
        int last_checked = -1, opened = 0;
        for (int i : map.keySet()) {
            if (opened > 0 && i > last_checked + 1 || opened > map.get(i)) return false;
            start.add(map.get(i) - opened);
            last_checked = i; 
            opened = map.get(i);
            if (start.size() == k) opened -= start.remove();
        }
        return opened == 0;
    }
}