//leetcode 796 Rotate String

/*
time: O(nm)
space: O(n)
*/

class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}