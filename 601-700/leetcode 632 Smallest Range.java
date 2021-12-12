// leetcode 632 Smallest Range Covering Elements from K Lists

/*
time: O(nlogm) n refers to the total number of elements in all the lists. mm refers to the total number of lists.
space: O(m)
*/

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]));
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
        	max = Math.max(max, nums.get(i).get(0));
        	pq.add(new int[] {i, 0});
        }

        while (pq.size() == nums.size()) {
            int e[] = pq.poll(), row = e[0], col = e[1];
            if (end - start > max - nums.get(row).get(col)) {
                start = nums.get(row).get(col);
                end = max;
            }
            if (col + 1 < nums.get(row).size()) {
                pq.offer(new int[]{row, col + 1});
                max = Math.max(max, nums.get(row).get(col + 1));
            }
        }
        return new int[] {start, end};
    }
}