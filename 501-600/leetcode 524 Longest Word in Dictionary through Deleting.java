// leetcode 524 Longest Word in Dictionary through Deleting

/*
time: O(nx)
space: O(x)
*/

public class Solution {
	public String findLongestWord(String s, List<String> dictionary) {
        String maxStr = "";
        for (String str : dictionary) {
            if (isSubsequence(str, s)) {
                if (str.length() > maxStr.length() || 
                	(str.length() == maxStr.length() && str.compareTo(maxStr) < 0)) maxStr = str;
            }
        }
        return maxStr;
    }

    private boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++) {
            if (x.charAt(j) == y.charAt(i)) j++;
        }
        return j == x.length();
    }
}