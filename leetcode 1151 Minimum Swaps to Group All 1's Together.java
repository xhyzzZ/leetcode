// leetcode 1151 Minimum Swaps to Group All 1's Together

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int minSwaps(int[] data) {
        int count = 0;
        for (int x : data) {
            if (x == 1) count++;
        }
        if (count <= 1) return 0;
        
        int i = 0, j = 0, zeroes = 0;
        while (j < count) {
            if (data[j++] == 0) zeroes++;
        }
        
        int res = zeroes;
        while (j < data.length) {
            if (data[j++] == 0) zeroes++;
            if (data[i++] == 0) zeroes--;
            
            res = Math.min(res, zeroes);
        }
        return res;
    }
}