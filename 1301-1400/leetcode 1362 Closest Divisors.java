// leetcode 1362 Closest Divisors

/*
time: O(logn)
space: O(n)
*/

class Solution {
    public int[] closestDivisors(int num) {
        int num1 = num + 1;
        int num2 = num + 2;
        int[] diff1 = closest(num1);
        int[] diff2 = closest(num2);
        int d1 = Math.abs(diff1[0] - diff1[1]);
        int d2 = Math.abs(diff2[0] - diff2[1]);
        
        return d1 < d2 ? diff1 : diff2;
    }
    private int[] closest(int num) {
        int[] res = new int[2];
        int diff = 0, min = Integer.MAX_VALUE;
        for (int i = (int) Math.sqrt(num); i > 0; i--) {
            int j = num / i;
            if (j * i == num) {
                // closest pair is (i,j)
                diff = Math.abs(i - j);
                if (diff < min) {
                    min = diff;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
    
}