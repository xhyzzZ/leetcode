// leetcode 1513 Number of Substrings With Only 1s

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int numSub(String s) {
        long cnt = 0;
        long res = 0;
        int mod = (int)1e9 + 7;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                cnt++;
            } else {
                res += helper(cnt);
                cnt = 0;
            }
        }
        if (cnt != 0) res += helper(cnt);
        return (int) (res % mod);
    }
    
    private long helper(long num) {
        if (num == 0) return 0;
        return (num + 1) * num / 2;
    }
}