// leetcode 2165 Smallest Value of the Rearranged Number

/*
time: O(nlogn)
space: O(n)
*/ 

class Solution {
    public long smallestNumber(long num) {
        // If it's negative, simple sort reversely all digits.
        // If it's positive, swap the fisrt digit and the first non-zero digit.
        String str = Stream.of(Long.toString(Math.abs(num)).split("")).sorted().collect(Collectors.joining());
        StringBuilder sb = new StringBuilder(str);
        if (num <= 0) return -1 * Long.parseLong(sb.reverse().toString());
        if (sb.charAt(0) == '0') {
            int firstNonZero = sb.lastIndexOf("0") + 1;
            sb.setCharAt(0, sb.charAt(firstNonZero));
            sb.setCharAt(firstNonZero, '0');
        }
        return Long.parseLong(sb.toString());
    }
}