// leetcode 76 Minimum Window Substring

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1] > 0) counter--;
            map[c1]--;
            while (counter == 0) {
                if (minLen > end - start + 1) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) counter++;
                start++;
            }
            end++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}