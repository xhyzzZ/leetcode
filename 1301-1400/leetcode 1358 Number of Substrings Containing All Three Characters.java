// leetcode 1358 Number of Substrings Containing All Three Characters

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int numberOfSubstrings(String s) {
        char[] str = s.toCharArray();
        int n = s.length();
        int res = 0, i = 0, j = 0;
        int[] count = {0, 0, 0};
        while (j < s.length()) {
            count[str[j] - 'a']++;
            j++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[str[i] - 'a']--;
                i++;
            }
            res += i; 
        }
        return res;
    }
}