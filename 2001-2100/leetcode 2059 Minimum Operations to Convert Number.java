// leetcode 2059 Minimum Operations to Convert Number

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        if (nums == null || nums.length == 0) return -1;
        
        Set<Integer> seen = new HashSet<>();
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int val = queue.poll();
                
                if (val == goal) return steps;
                if (val < 0 || val > 1000) continue;
                if (seen.contains(val)) continue;
                seen.add(val);
                
                for (int num : nums) {
                    queue.offer(val + num);
                    queue.offer(val - num);
                    queue.offer(val ^ num);
                }
            }
            steps++;
        }
        return -1;
    }
}