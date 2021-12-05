// leetcode 796 Rotate String

/*
time: O(nm)
space: O(n)
*/

class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}