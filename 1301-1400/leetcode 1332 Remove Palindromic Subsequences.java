// leetcode 1332 Remove Palindromic Subsequences

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) return 0; 
        if (isPalindrome(s)) return 1; 
        return 2; 
    }
    
    private static boolean isPalindrome(String str) { 
        int l = 0; 
        int h = str.length() - 1; 

        while (h > l) {
            if (str.charAt(l++) != str.charAt(h--)) 
                return false; 
        }
        return true; 
    } 
}