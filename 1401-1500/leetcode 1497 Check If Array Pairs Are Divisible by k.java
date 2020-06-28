// leetcode 1497 Check If Array Pairs Are Divisible by k

/*
time: O(n)
space: O(n)
*/

class Solution {
    public boolean canArrange(int[] arr, int k) {
		int[] freq = new int[k];
        for (int x : arr) {
            x %= k;
            if (x < 0) x += k;
            freq[x]++;
        }
        
        for (int i = 1; i <= k / 2; i++) {
            if (freq[i] != freq[k - i]) return false;
        }
			
        return freq[0] % 2 == 0;
    }
}
