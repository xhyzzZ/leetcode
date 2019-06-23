//leetcode 256 Paint House

/*
time: O(n)
space: O(1)

/* Typical 1D DP problem with 3 dp array red, green, blue
 * red[i] means the minimum cost to print house i to red; red[i] = Math.min(green[i - 1], blue[i - 1]) + costs[i]-0;
 * but since we only need data at i - 1 to update i, we only need to store the i-1 datapoint instead of the whole array
 */ 

class Solution {
    public int minCost(int[][] costs) {
    	if(costs == null) return 0;
        int red = 0, green = 0, blue = 0;
        int m = costs.length;
        for (int i = 0; i < m; i++) {
            int rr = red, bb = blue, gg = green; 
            red = costs[i][0] + Math.min(bb, gg);
            blue = costs[i][1] + Math.min(rr, gg);
            green = costs[i][2] + Math.min(rr, bb);
        }
        return Math.min(Math.min(blue, green), red); 
    }
}