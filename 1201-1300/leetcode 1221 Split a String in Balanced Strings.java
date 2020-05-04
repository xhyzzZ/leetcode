// leetcode 1221 Split a String in Balanced Strings

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int balancedStringSplit(String s) {
        int isLeft = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') isLeft++;
            else isLeft--;
            
            if (isLeft == 0) res++;
        }
        return res;
    }
}