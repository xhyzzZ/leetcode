// leetcode 1281 Subtract the Product and Sum of Digits of an Integer

/*
time: O(logn)
space: O(1)
*/

class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int mul = 1;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            mul *= digit;
            n = n / 10;
        }
        return mul - sum;
    }
}