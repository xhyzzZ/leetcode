// leetcode 2144 Minimum Cost of Buying Candies With Discount

/*
time: O(nlogn)
space: O(1)
*/ 

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        
        int res = 0, index = 1;
        for (int i = cost.length - 1; i >= 0; i--) {
            if (index % 3 != 0) res += cost[i];
            index++;
        }
        return res;
    }
}