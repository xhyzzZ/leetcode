// leetcode 1447 Simplified Fractions

/*
time: O(n^2 * logn)
space: O(n^2)
*/

class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = n; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                int gcd = gcd(i, j);
                if (gcd == 1) {
                    String s = j + "/" + i;
                    res.add(s);
                }
            }
        }
        return res;
    }
    
    private int gcd(int a, int b) { 
        if (a == 0) return b; 
          
        return gcd(b % a, a); 
    } 
}