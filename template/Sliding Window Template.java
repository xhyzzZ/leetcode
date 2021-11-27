Sliding Window Template

// int[26] for Letters 'a' - 'z' or 'A' - 'Z': design for index
// int[128] for ASCII： no need to minus 'a' or 'A'
// int[256] for Extended ASCII

// 1. 判断有无counter
// 2. 注意len要+1因为end++在最后
// 3. 根据是字母还是数字选择int[] 或者map 
public class Solution {
	public int template(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;

        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1] == 0) counter++;
            map[c1]++;
            
            while (counter > 2) {
                char c2 = s.charAt(start);
                if (map[c2] == 1) counter--;
                map[c2]--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}