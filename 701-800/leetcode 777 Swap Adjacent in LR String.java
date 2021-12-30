// leetcode 777 Swap Adjacent in LR String

/*
time: O(n)
space: O(1)
*/

class Solution {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) return false;
        
        int i = 0, j = 0;
        
        while (i < start.length() && j < end.length()) {
            
            // get the non-X positions of 2 strings
            while (i < start.length() && start.charAt(i) == 'X') i++;
            while (j < end.length() && end.charAt(j) == 'X') j++;
            
            // if both of the pointers reach the end the strings are transformable
            if (i == start.length() && j == end.length()) return true;
            // if only one of the pointer reach the end they are not transformable
            if (i == start.length() || j == end.length()) return false;
            
            if (start.charAt(i) != end.charAt(j)) return false;
            // if the character is 'L', it can only be moved to the left. i should be greater or equal to j.
            if (start.charAt(i) == 'L' && j > i) return false;
            // if the character is 'R', it can only be moved to the right. j should be greater or equal to i.
            if (start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return true;
    }
}