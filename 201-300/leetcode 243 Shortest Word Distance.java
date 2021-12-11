// leetcode 243 Shortest Word Distance

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
	    for (int i = 0, index1 = -1, index2 = -1; i < words.length; i++) {
	        if (words[i].equals(word1)) {
	            index1 = i;
	            if (index2 != -1) res = Math.min(res, index1 - index2);
	        }
	        if (words[i].equals(word2)) {
	            index2 = i;
	            if (index1 != -1) res = Math.min(res, index2 - index1);
	        }
	    }
	    return res;
    }
}