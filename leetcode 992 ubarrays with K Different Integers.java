//leetcode 992 ubarrays with K Different Integers

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);  
    }
    
    // all subarrays with <= K distinct numbers are counted.
    private int atMostK(int[] A, int K) {
        int i = 0, j = 0;
        int total = 0;
        int distinct = 0;   // count of distinct numbers in the window.
        Map<Integer, Integer> counter = new HashMap<>();
        while (j < A.length) {
            if (counter.getOrDefault(A[j], 0) == 0) {
                distinct++;
            }
            counter.put(A[j], counter.getOrDefault(A[j], 0) + 1);
            j++;
            while (i < j && distinct > K) {  // shrink the left boundary of window.
                counter.put(A[i], counter.get(A[i]) - 1);
                if (counter.get(A[i]) == 0) {
                    distinct--;
                }
                i++;
            }
            total += j - i;  
        }
        return total;
    }
}