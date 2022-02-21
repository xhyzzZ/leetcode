// leetcode 2131 Longest Palindrome by Concatenating Two Letter Words

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        int unpaired = 0, ans = 0;
        for (String word : words) {
            if (!count.containsKey(word)) count.put(word, 0);
            if (word.charAt(0) == word.charAt(1)) {
                if (count.get(word) > 0) {
                    unpaired--;
                    count.put(word, count.get(word) - 1);
                    ans += 4;
                } else {
                    count.put(word, count.get(word) + 1);
                    unpaired++;
                }
            } else {
                String rev = Character.toString(word.charAt(1)) + Character.toString(word.charAt(0));
                if (count.containsKey(rev) && count.get(rev) > 0) {
                    ans += 4;
                    count.put(rev, count.get(rev) - 1);
                } else count.put(word, count.get(word) + 1);
            }

        }
        if (unpaired > 0) ans += 2;
        return ans;
    }
}