// leetcode 1323 Maximum 69 Number

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int maximum69Number (int num) {
        String n = Integer.toString(num);
        char[] chs = n.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (c == '6') {
                chs[i] = '9';
                break;
            }
        }
        String newString = String.valueOf(chs);
        return Integer.parseInt(newString);
    }
}