//leetcode 750 Number Of Corner Rectangles

/*
time: O()
space: O()
*/

class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        
	    for (int i = 0; i < m; i++) {
	        for (int p = i + 1; p < m; p++) {
	            int c = 0;
	                
	            for (int k = 0; k < n; k++) {
	                c += grid[i][k] & grid[p][k];
	            }
	                
	            res += (c * (c - 1)) >> 1;
	        }
	    }
	        
	    return res;
    }
}