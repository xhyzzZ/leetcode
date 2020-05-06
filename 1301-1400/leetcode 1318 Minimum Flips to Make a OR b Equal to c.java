// leetcode 1318 Minimum Flips to Make a OR b Equal to c

/*
time: O(1)
space: O(1)
*/

class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        while (a != 0 || b != 0 || c != 0) {
            int res1 = a % 2, res2 = b % 2, res3 = c % 2;
            if (res3 == 0) {
                res += (res1 + res2);
            } else {
                if (res1 + res2 == 0)
                    res += 1;
            }
            a /= 2;
            b /= 2;
            c /= 2;
        }
        return res;
    }
}