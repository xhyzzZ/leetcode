// leetcode 1317 Convert Integer to the Sum of Two No-Zero Integers

/*
time: O(nlogn)
space: O(2)
*/

class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        for (int i = 1; i < n; i++) {
            if (!checkZero(i) && !checkZero(n - i)) {
                res[0] = i;
                res[1] = n - i;
            }
        }
        return res;
    }
    public boolean checkZero(int x) {
        while (x != 0) { 
            if (x % 10 == 0) return true; 
            x /= 10; 
        } 
        return false; 
    }
}