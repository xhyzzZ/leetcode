//leetcode 846 Hand of Straights

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) map.put(i, map.getOrDefault(i, 0) + 1);
        Queue<Integer> start = new LinkedList<>();
        int last_checked = -1, opened = 0;
        for (int i : map.keySet()) {
            if (opened > 0 && i > last_checked + 1 || opened > map.get(i)) {
            	return false; 
            }
            start.add(map.get(i) - opened);
            last_checked = i; 
            opened = map.get(i);
            if (start.size() == groupSize) {
            	opened -= start.remove();
            }
        }
        return opened == 0;
    }
}