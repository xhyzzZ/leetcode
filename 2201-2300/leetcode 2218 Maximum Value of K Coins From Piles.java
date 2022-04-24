// leetcode 2218 Maximum Value of K Coins From Piles

/*
time: O(nm)
space: O(nk)
*/

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        Integer[][] memo = new Integer[piles.size() + 1][k + 1];
        return solve(piles, memo, 0, k);
    }

    private int solve(List<List<Integer>> piles, Integer[][] memo, int index, int k) {
        if (k == 0 || index == piles.size()) return 0;
        int res = 0, sum = 0;
        if (memo[index][k] != null) return memo[index][k];
        // either dont take from that pile
        res = Math.max(res, solve(piles, memo, index + 1, k));
        for (int i = 0; i < Math.min(piles.get(index).size(), k); i++) {
            sum += piles.get(index).get(i);
            // or take some certain prefix from that pile, if we can take that much elements.
            res = Math.max(res, sum + solve(piles, memo, index + 1, k - (i + 1)));
        }
        return memo[index][k] = res;
    }
}