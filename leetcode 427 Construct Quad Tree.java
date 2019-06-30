//leetcode 427 Construct Quad Tree

/*
time: O()
space: O()
*/

class Solution {
    public Node construct(int[][] grid) { 
    	return build(0, 0, grid.length - 1, grid.length - 1, grid);
    }

    private Node build(int r1, int c1, int r2, int c2, int[][] grid) {
        if (r1 > r2 || c1 > c2) return null;
        boolean isLeaf = true;
        int val = grid[r1][c1];
        for(int i = r1; i <= r2; i++) {
            for(int j = c1; j <= c2; j++) {
            	if(grid[i][j] != val) {
                    isLeaf = false;
                    break;
                }
            }    
        }
        if(isLeaf) {
            return new Node(val == 1, true, null, null, null, null);
        }
        int rowMid = (r1 + r2) / 2, colMid = (c1 + c2) / 2;
        return new Node(false, false,
            build(r1, c1, rowMid, colMid, grid),//top left 
            build(r1, colMid + 1, rowMid, c2, grid),//top right
            build(rowMid + 1, c1, r2, colMid, grid),//bottom left 
            build(rowMid + 1, colMid + 1, r2, c2, grid));//bottom right
    }
}
	
