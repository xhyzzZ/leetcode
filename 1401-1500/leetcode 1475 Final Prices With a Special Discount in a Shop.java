// leetcode 1475 Final Prices With a Special Discount in a Shop

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] finalPrices(int[] prices) {
        int[] res = prices.clone();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; ++i) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                res[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return res;  
    }
}