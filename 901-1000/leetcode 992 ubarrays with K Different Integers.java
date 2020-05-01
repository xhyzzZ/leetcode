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
        int sum = 0;
        int counter = 0;   // count of distinct numbers in the window.
        Map<Integer, Integer> map = new HashMap<>();
        while (j < A.length) {
            if (map.getOrDefault(A[j], 0) == 0) {
                counter++;
            }
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            j++;
            while (i < j && counter > K) {  // shrink the left boundary of window.
                map.put(A[i], map.get(A[i]) - 1);
                if (map.get(A[i]) == 0) {
                    counter--;
                }
                i++;
            }
            sum += j - i;  
        }
        return sum;
    }
}