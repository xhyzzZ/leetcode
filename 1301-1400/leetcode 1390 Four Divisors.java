// leetcode 1390 Four Divisors

/*
time: O(nlogn)
space: O(1)
*/

class Solution {
    public int sumFourDivisors (int[] nums) {
		int sum = 0;
		for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num) continue;
            
            int tmpSum = num + 1;
            int count = 0;
            for (int i = 2; i <= sqrt; i++) {
                if (num % i == 0) {
                    count++;
                    tmpSum += (i + num / i);
                }
                
                if (count > 1) break;
            }
            if (count == 1) sum += tmpSum;
		}
		return sum;
    }  
}