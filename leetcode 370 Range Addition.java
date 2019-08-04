//leetcode 370 Range Addition

/*
time: O(n + k)
space: O(n)
*/

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        if (length <= 0) return new int[0];
		int[] res = new int[length];
		for (int[] update : updates) {
			int start = update[0];
			int end = update[1];
			int val = update[2];

			res[start] += val;
			if(end + 1 < length) res[end + 1] -= val;
		}

		int carry = 0;
		for (int i = 0; i < length; i++) {
			res[i] += carry;
			carry = res[i];
		}
		return res;
    }
}