//leetcode 592 Fraction Addition and Subtraction

/*
time: O()
space: O()
*/

class Solution {
    public String fractionAddition(String expression) {
    	if (expression == null || expression.length() == 0) return "0/1";
    	String[] tokens = expression.split("(?=[+-])");
        int len = tokens.length;
        int[] numerators = new int[len];
        int[] denominators = new int[len];
        for (int i = 0; i < len; i++) {
            numerators[i] = Integer.parseInt(tokens[i].split("/")[0]);
            denominators[i] = Integer.parseInt(tokens[i].split("/")[1]);
        }
        long denominator = 1, numerator = 0;
        for (int i = 0; i < len; i++) {
            denominator *= denominators[i];
        }
        for (int i = 0; i < len; i++) {
            numerator += denominator * numerators[i] / denominators[i];
        }
        long A = Math.abs(gcd(denominator, numerator));
        String res = numerator / A + "/" + denominator / A;
        return res;
    }
    private long gcd (long x , long y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }
}