// leetcode 1456 Maximum Number of Vowels in a Substring of Given Length

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int maxVowels(String s, int k) {
        int start = 0, end = 0, counter = 0, max = Integer.MIN_VALUE, count = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (check(c)) count++;
            counter++;
            end++;
            while (counter > k) {
                counter--;
                if (check(s.charAt(start))) count--;
                start++;
            }
            
            max = Math.max(max, count);
        }
        return max;
    }
    
    private boolean check(char c) {
        return c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u';
    }
}