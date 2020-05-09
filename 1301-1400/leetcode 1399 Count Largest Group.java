// leetcode 1399 Count Largest Group

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            int total = map.getOrDefault(sum, 0) + 1;
            max = Math.max(max, total);
            map.put(sum, total);
        }
        
        for (int count : map.values()) {
            if (count == max) {
                res++;
            }
        }
        
        return res;
    }
    
    private int getSum(int n) {     
        int sum = 0; 
        while (n != 0) { 
            sum = sum + n % 10; 
            n = n / 10; 
        } 
      
        return sum; 
    } 
}