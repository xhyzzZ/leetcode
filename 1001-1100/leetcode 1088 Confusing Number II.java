// leetcode 1088 Confusing Number II

/*
time: O(5^log10N)
space: O(log10N)
*/

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    public int confusingNumberII(int n) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        helper(n, 0);
        return res;
    }

    private void helper(int n, long cur) {
        if (isConfusingNumber(cur)) res++;
        for (int i : map.keySet()) {
            if (cur * 10 + i <= n && cur * 10 + i != 0) {
                helper(n, cur * 10 + i);
            }
        }
    }
    
    private boolean isConfusingNumber(long n) {
        long src = n;
        long res = 0;
        while (n > 0) {
            res = res * 10 + map.get((int) n % 10); 
            n /= 10;
        }
        return res != src;
    }
}