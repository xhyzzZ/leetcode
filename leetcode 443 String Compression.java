//leetcode 443 String Compression

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int compress(char[] chars) {
        int j = 0;
        for(int i = 1, cnt = 1; i <= chars.length; i++){
            if(i < chars.length && chars[i] == chars[i - 1]) cnt++;
            else {
                chars[j++] = chars[i - 1];
                if(cnt != 1) {
                    for(char c : String.valueOf(cnt).toCharArray()) chars[j++] = c;
                    cnt = 1;
                }
            }
        } 
        return j;
    }
}
