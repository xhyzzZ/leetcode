// leetcode 2042 Check if Numbers Are Ascending in a Sentence

/*
time: O(n)
space: O(n)
*/

class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = 0;
    
        for (String str : s.split(" ")) {
            if (Character.isDigit(str.charAt(0))) {
                int number = Integer.parseInt(str);
                if (number <= prev) return false;
                prev = number;
            }
        }
        return true;
    }
}