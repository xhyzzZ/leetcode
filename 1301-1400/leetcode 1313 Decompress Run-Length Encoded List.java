// leetcode 1313 Decompress Run-Length Encoded List

/*
time：O(n)
space: O(n)
*/

class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> store = new ArrayList<>();
        for (int i = 0; i < nums.length / 2; i++) {
            int freq = nums[2 * i];
            int val = nums[2 * i + 1];
            for (int j = 0; j < freq; j++) {
                store.add(val);
            }
        }
        
        int[] res = new int[store.size()];
        for (int i = 0; i < store.size(); i++) {
            res[i] = store.get(i);
        }
        return res;
    }
}