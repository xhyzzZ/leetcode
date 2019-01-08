//leetcode 59 Spiral Matrix II


/*
time: O(n)
space: O(n)
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int num = 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd) {
        	for(int i = colBegin; i < colEnd; i++) {
        		matrix[rowBegin][i] = num++;
        	}
        	rowBegin++;
 
        	for(int i =rowBegin; i <= rowEnd; i++) {
        		matrix[i][colEnd] = num++
        	}
        	colEnd--;

        	for(int i = colEnd; i >= colBegin; i--) {
        		matrix[rowEnd][i] = num++
        	}
        	rowEnd--;

        	for(int i = rowEnd; i >= rowBegin; i--) {
        		matrix[i][rowBegin] = num++
        	}
        	colBegin++;
        }
        return matrix;
    }
}