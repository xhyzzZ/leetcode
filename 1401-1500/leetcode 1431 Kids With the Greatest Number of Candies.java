// leetcode 1431 Kids With the Greatest Number of Candies

/*
time: O(n)
space: O(n)
*/

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                res.add(true);
            } else res.add(false);
        }
        return res;
    }
}