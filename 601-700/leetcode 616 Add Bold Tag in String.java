//leetcode 616 Add Bold Tag in String

/*
time: O()
space: O()
*/

class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
        	for (String word : dict) {
        		if (s.startsWith(word, i)) {
        			end = Math.max(end, i + word.length());
        		}
        	}
        	bold[i] = end > i;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        	if (!bold[i]) {
        		res.append(s.charAt(i));
        		continue;
        	}
        	int j = i;
        	while (j < s.length() && bold[j]) j++;
        	res.append("<b>" + s.substring(i, j) + "</b>");
        	i = j - 1;
        }
        return res.toString();
    }
}