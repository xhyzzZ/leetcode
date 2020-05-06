// leetcode 1334 Find the City With the Smallest Number of Neighbors at a Threshold Distance

/*
time: O()
space: O()
*/

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for (int[] me : matrix) {
            Arrays.fill(me, 10000); 
        }
        
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], dis = edge[2];
            matrix[from][to] = dis;
            matrix[to][from] = dis;
        }
        
        for (int k = 0; k < n; k++) { 
            for (int i = 0; i < n; i++) { 
                for (int j = 0; j < n; j++) { 
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) 
                        matrix[i][j] = matrix[i][k] + matrix[k][j]; 
                } 
            } 
        } 
        
        int res = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] <= distanceThreshold && i != j) {
                    count++;
                }
            }
            if (count <= min) {
                min = count;
                res = i;
            }
        }
        return res;
    }
}