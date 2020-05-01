//leetcode 309 Best Time to Buy and Sell Stock with Cooldown

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0, rest = 0, hold = Integer.MIN_VALUE;
	    for (int price : prices) {
	    	int prev_sold = sold;
	    	sold = hold + price;
	        hold = Math.max(rest - price, hold);
	        rest = Math.max(prev_sold, rest);
	    }
	    return Math.max(rest, sold);
    }
}