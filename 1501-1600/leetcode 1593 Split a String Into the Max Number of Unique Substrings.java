// leetcode 1593 Split a String Into the Max Number of Unique Substrings

/*
time: O(2^n * n)
space: O(n)
*/

class Solution {
    public int maxUniqueSplit(String s) {
        return dfs(s, new HashSet<>());
    }

    private int dfs(String s, Set<String> set) {
        if (s.length() == 0) return 0;
        int res = Integer.MIN_VALUE;

        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (set.add(sub)) {
                res = Math.max(, dfs(s.substring(i), set) + 1);
                set.remove(sub);
            }
        }
        return res;
    }
}res