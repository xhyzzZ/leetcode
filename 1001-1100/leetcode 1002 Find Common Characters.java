//leetcode 1002 Find Common Characters

/*
time: O(n)
space: O(1)
*/

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26]; 
        Arrays.fill(count, Integer.MAX_VALUE);
        for(String str : A) {
            int[] cnt = new int[26];
            for(int i = 0; i < str.length(); ++i) { ++cnt[str.charAt(i) - 'a']; } // count each char's frequency in string str.
            for(int i = 0; i < 26; ++i) { count[i] = Math.min(cnt[i], count[i]); } // update minimum frequency.
        }
        for(char c = 'a'; c <= 'z'; ++c) {
            while(count[c - 'a']-- > 0) { ans.add("" + c); }
        }
        return ans;
    }
}