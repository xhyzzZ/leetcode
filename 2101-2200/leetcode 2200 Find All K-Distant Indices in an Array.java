// leetcode 2200 Find All K-Distant Indices in an Array

/*
time: O(n)
space: O(n)
*/

class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            if (nums[i] == key) {
                int start = Math.max(0, i - k);   // initialize the start
                int end = Math.min(len - 1, i + k);   // intialize the end

                // check if any index is stored earlier, avoid overlapping intervals
                if (res.size() != 0) start = Math.max(res.get(res.size() - 1) + 1, start); 

                for (int j = start; j <= end; j++) res.add(j);
            }
        }
        return res;
    }
}