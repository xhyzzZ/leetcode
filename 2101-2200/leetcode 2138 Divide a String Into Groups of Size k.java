// leetcode 2138 Divide a String Into Groups of Size k

/*
time: O(n)
space: O(n)
*/

class Solution {
    public String[] divideString(String s, int k, char fill) {
        while (s.length() % k != 0) s += fill;
        String[] res = new String[s.length() / k];
        int i = 0;
        int index = 0;

        while (i < s.length()) {
            String sub = s.substring(i, i + k);
            res[index++] = sub;
            i = i + k;
        }
        return res;
    }
}