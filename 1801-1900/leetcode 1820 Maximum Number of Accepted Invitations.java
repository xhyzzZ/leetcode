// leetcode 1820 Maximum Number of Accepted Invitations

/*
time: O(n^3)
space: O(n)
*/

class Solution {
    public int maximumInvitations(int[][] grid) {
        int m = grid.length; // boys
        int n = grid[0].length; // girls

        int[] girlFixed = new int[n];

        for (int i = 0; i < n; i++) girlFixed[i] = -1;

        int invitations = 0;

        for (int i = 0; i < m; i++) {
            Set<Integer> seenGirl = new HashSet<>();

            if (dfs(grid, i, seenGirl, girlFixed)) {
                invitations++;
            }
        }
        return invitations;
    }

    private boolean dfs(int[][] grid, int boy, Set<Integer> seenGirl, int[] girlFixed) {
        int m = grid.length; // boys
        int n = grid[0].length; // girls

        for (int i = 0; i < n; i++) {
            if (grid[boy][i] == 1 && !seenGirl.contains(i)) {
                seenGirl.add(i);
                if (girlFixed[i] == -1 || dfs(grid, girlFixed[i], seenGirl, girlFixed)) {
                    girlFixed[i] = boy;
                    return true;
                }
            }
        }
        return false;
    }
}