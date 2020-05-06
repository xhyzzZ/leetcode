// leetcode 1333 Filter Restaurants by Vegan-Friendly, Price and Distance

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]);
        for (int[] re : restaurants) {
            if (veganFriendly == 1) {
                if (re[2] == 1 && re[3] <= maxPrice && re[4] <= maxDistance) {
                    pq.add(re);
                }
            } else {
                if (re[3] <= maxPrice && re[4] <= maxDistance) {
                    pq.add(re);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll()[0]);
        }
        return res;
    }
}