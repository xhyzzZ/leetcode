// leetcode 1491 Average Salary Excluding the Minimum and Maximum Salary

/*
time: O(n)
space: O(1)
*/

class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int sum = 0;
        for (int x : salary) {
            sum += x;
            max = Math.max(x, max);
            min = Math.min(x, min);
        }
        
        return (double) (sum - max - min) / (salary.length - 2);
    }
}