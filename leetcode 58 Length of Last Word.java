//leetcode 58 Length of Last Word


/*
time: O(1)
space: O(1)
*/
public class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}