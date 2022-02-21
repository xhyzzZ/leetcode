// leetcode 256 Paint House

/*
time: O(n)
space: O(1)
/*
如果第i个房子要涂成红色，那么他的值由第i - 1的房子（绿色和蓝色选最小的）加上这层红色的值
paintCurrentRed = min(paintPreviousGreen,paintPreviousBlue) + costs[i+1][0]
*/ 

class Solution {
    public int minCost(int[][] costs) {
    	if (costs == null || costs.length == 0) return 0;
        int lastR = costs[0][0];
        int lastG = costs[0][1];
        int lastB = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int curR = Math.min(lastG, lastB) + costs[i][0];
            int curG = Math.min(lastR, lastB) + costs[i][1];
            int curB = Math.min(lastR, lastG) + costs[i][2];
            lastR = curR;
            lastG = curG;
            lastB = curB;
        }
        return Math.min(Math.min(lastR, lastG), lastB);
    }
}