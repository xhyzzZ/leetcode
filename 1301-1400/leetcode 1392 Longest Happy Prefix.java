// leetcode 1392 Longest Happy Prefix

/*
time: O(n)
space: O(n)
*/

class Solution {
    public String longestPrefix(String s) {
        int len = kmp(s);   
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++)  
            sb.append(s.charAt(i));  
        return sb.toString();   
    }
    
    private int kmp(String s) {
        int n = s.length(); 
        int[] lps = new int[n]; 
        lps[0] = 0;   
        int len = 0; 
      
        int i = 1; 
        while (i < n) { 
            if (s.charAt(i) == s.charAt(len)) { 
                len++; 
                lps[i] = len; 
                i++; 
            } else {  
                if (len != 0) { 
                    len = lps[len - 1]; 
      
                } else { 
                    lps[i] = 0; 
                    i++; 
                } 
            } 
        } 
        int res = lps[n - 1]; 
       
        return res;
    }    
}