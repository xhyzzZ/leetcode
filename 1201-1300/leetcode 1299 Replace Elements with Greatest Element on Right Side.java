// leetcode 1299 Replace Elements with Greatest Element on Right Side

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int[] replaceElements(int[] arr) {
        for (int i = arr.length - 1, max = -1; i >= 0; --i) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(max, tmp);
        }
        return arr;
    }
}