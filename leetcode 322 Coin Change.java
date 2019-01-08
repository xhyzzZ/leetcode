//leetcode 322 Coin Change

/*
time: O()
space: O()
*/

class Solution {
    private int minCount = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
       	Arrays.sort(coins);
		count(amount, coins.length - 1, coins, 0);
		return minCount == Integer.MAX_VALUE ? - 1 : minCount;
    }
	private void count(int amount, int index, int[] coins, int count) {
	    if (index < 0 || count + 2 > minCount) return;
		for (int i = amount / coins[index]; i >= 0; i--) {
			int newAmount = amount - i * coins[index];
			int newCount = count + i;
			if (newAmount > 0 && newCount + 1 < minCount) 
			    count(newAmount, index - 1, coins, newCount);
			else{
			    if (newAmount == 0 && newCount < minCount)
			        minCount = newCount;
			    break;
			}
		}
    }
}
