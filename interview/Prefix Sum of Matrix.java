// Prefix Sum of Matrix

/*[10, 20, 30]      [10, 30, 60 ]
  [5,  10, 20]  ->  [15, 45, 95 ]
  [2,  4,  6 ]      [17, 51, 107]
*/

public void prefixSum2D(int[][] grid) {
	int m = grid.length; 
	int n = grid[0].length; 
	int[][] psa = new int[m][n]; 
	psa[0][0] = grid[0][0]; 
	// Filling first row and first column 
	for (int i = 1; i < n; i++) {
		psa[0][i] = psa[0][i - 1] + grid[0][i]; 
	}
	for (int i = 1; i < m; i++) {
		psa[i][0] = psa[i - 1][0] + grid[i][0]; 
	}
	// updating the values in the 
	// cells as per the general formula. 
	for (int i = 1; i < m; i++) {
		for (int j = 1; j < n; j++) {
			// values in the cells of new array 
			// are updated 
			psa[i][j] = psa[i - 1][j] + psa[i][j - 1] 
						- psa[i - 1][j - 1] + grid[i][j];
		}	 
	}

	for (int i = 0; i < m; i++) { 
		for (int j = 0; j < n; j++) {
			System.out.print(psa[i][j] + " "); 
		}
		System.out.println(); 
	} 
} 
