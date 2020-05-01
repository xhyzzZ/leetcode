//leetcode 482 License Key Formatting

/*
time: O(n)
space: O()
*/

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String str = S.toUpperCase();

        for (int i = str.length() - 1; i >= 0; i--) {
        	char ch = str.charAt(i);
        	if (ch != '-') {
        		if (count == K) {
        			sb.append("-");
        			count = 0;
        			sb.append(ch);
        		} else {
        			sb.append(ch);
        		}
        		count++;
        	}
        }
        return sb.reverse().toString();
    }
}