// leetcode 678 Valid Parenthesis String

/*
time: O(n)
space: O(1)
*/

class Solution {
    public boolean checkValidString(String s) {
        int openCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                openCount--;
            }
            // Currently, don't have enough open parentheses to match close parentheses-> Invalid
            // For example: ())(
            if (openCount < 0) return false;    
        }
        return openCount == 0; // Fully match open parentheses with close parentheses
    }
}