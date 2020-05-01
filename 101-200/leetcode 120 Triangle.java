//leetcode 120 Triangle


/*
time: O()
space: O()
*/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
        	for (j = 0; j <= i; j++) {
        		A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
        	}
        }
        return A[0];
    }
}