// leetcode 263 Ugly Number

/*
time: O()
space: O()
*/

class Solution {
    public boolean isUgly(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }   
        return num == 1;
    }
}