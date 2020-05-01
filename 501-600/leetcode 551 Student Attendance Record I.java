//leetcode Student Attendance Record I

/*
time: O(n)
space: O(1)
*/

class Solution {
    public boolean checkRecord(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }
}