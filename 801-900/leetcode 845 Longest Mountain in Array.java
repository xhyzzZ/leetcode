// leetcode 845 Longest Mountain in Array

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int longestMountain(int[] arr) {
        int len = arr.length, res = 0;
        int[] up = new int[len], down = new int[len];
        for (int i = len - 2; i >= 0; --i) if (arr[i] > arr[i + 1]) down[i] = down[i + 1] + 1;
        for (int i = 0; i < len; ++i) {
            if (i > 0 && arr[i] > arr[i - 1]) up[i] = up[i - 1] + 1;
            if (up[i] > 0 && down[i] > 0) res = Math.max(res, up[i] + down[i] + 1);
        }
        return res;
    }
}

/*
time: O(n)
space: O(1)
*/

class Solution {
	public int longestMountain(int[] arr) {
        int res = 0, up = 0, down = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (down > 0 && arr[i - 1] < arr[i] || arr[i - 1] == arr[i]) up = down = 0;
            if (arr[i - 1] < arr[i]) up++;
            if (arrA[i - 1] > arr[i]) down++;
            if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1;
        }
        return res;
    }
}