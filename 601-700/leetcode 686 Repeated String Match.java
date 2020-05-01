//leetcode 686 Repeated String Match

/*
time: O()
space: O()
*/

class Solution {
    public int repeatedStringMatch(String A, String B) {
        int count = 0;
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < B.length()) {
	        sb.append(A);
	        count++;
	    }
	    if(sb.toString().contains(B)) return count;
	    if(sb.append(A).toString().contains(B)) return ++count;
	    return -1;
    }
}