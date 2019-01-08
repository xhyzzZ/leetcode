//leetcode 9 Palindrome Number


//corner case: 1000
//O(n)
//space: O(1)
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || x !=0 && x % 10 == 0) return false;
        int pa = x;
        int rev = 0;
        while(x > 0) {
        	rev = rev * 10 + x % 10;
        	x /= 10;
        }
        return pa == rev;
    }
}