//leetcode 326 Power of Three

/*
time: O()
space: O()
*/

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n > 1) {
        	while (n % 3 == 0) n /= 3;
        }
    	return n == 1;
    }
}