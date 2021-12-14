// leetcode 904 Fruit Into Baskets

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int totalFruit(int[] fruits) {
    	if (fruits == null || fruits.length == 0) return 0;
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, start = 0, end = 0;
        while (end < fruits.length) {
            count.put(fruits[end], count.getOrDefault(fruits[end], 0) + 1);
            while (count.size() > 2) {
                count.put(fruits[start], count.get(fruits[start]) - 1);
                if (count.get(fruits[start]) == 0) count.remove(fruits[start]);
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}