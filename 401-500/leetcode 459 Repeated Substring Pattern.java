//leetcode 459 Repeated Substring Pattern

/*
time: O(n^2)
space: O(n)
*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
    	for(int i = len / 2; i >= 1; i--) {
    		if(len % i == 0) {
    			int m = len / i;
    			String subS = s.substring(0, i);
    			int j;
    			for(j = 1; j < m; j++) {
    				if(!subS.equals(s.substring(j * i, i + j * i))) break;
    			}
    			if(j == m) return true;
    		}
    	}
    	return false;
    }
}
