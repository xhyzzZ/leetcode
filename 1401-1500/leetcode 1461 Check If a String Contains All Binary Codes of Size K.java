// leetcode 1461 Check If a String Contains All Binary Codes of Size K

/*
time: O(2^k)
space: O(n)
*/

class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> seen = new HashSet<>();
        for (int i = k; i <= s.length(); ++i) {
            seen.add(s.substring(i - k, i));
        }
        return seen.size() == 1 << k;
    } 
}