// leetcode 1910 Remove All Occurrences of a Substring

/*
time: O(n)
space: O(1)
*/

class Solution {
    public String removeOccurrences(String s, String part) {
        int index = s.indexOf(part);
        while (index != -1) {
            s = s.substring(0, index) + s.substring(index + part.length());
            index = s.indexOf(part);
        }
        return s;
    }
}