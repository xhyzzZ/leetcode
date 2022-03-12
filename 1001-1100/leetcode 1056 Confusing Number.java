// leetcode 1056 Confusing Number

/*
time: O(n)
space: O(n)
*/

class Solution {
    public boolean confusingNumber(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(6, 9);
        map.put(9, 6);
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8); 
        int newNum = 0;
        int x = n;
        while (x != 0) {
            int remainder = x % 10;
            if (!map.containsKey(remainder)) 
                return false;
            if(newNum > Integer.MAX_VALUE / 10)
                return false;
            newNum = newNum * 10 + map.get(remainder);
            x /= 10;
        }    
        return n != newNum;
    }
}