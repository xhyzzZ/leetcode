// leetcode 2209 Minimum White Tiles After Covering With Carpets

/*
time: O(NC)
space: O(NC)
*/

class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        char[] chs = floor.toCharArray();
        int[] prefix = new int[chs.length];
        int c = 0;
        Integer[][] memo = new Integer[chs.length + 1][numCarpets + 1];
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '1') c++;
            prefix[i] = c;
        }
        
        return prefix[chs.length - 1] - solve(memo, prefix, 0, chs, numCarpets, carpetLen);  // total ones - max removed
    }
    
    private int solve(Integer[][] memo, int[] prefix, int index, char[] chs, int numCarpets, int carpetLen) {
        if (index >= chs.length || numCarpets == 0) return 0;
        if (memo[index][numCarpets] != null) return memo[index][numCarpets];
        int ones = prefix[Math.min(index + carpetLen - 1, chs.length - 1)] - (index == 0 ? 0 : prefix[index - 1]);
        // either take it and add one's count in that subsegment
        int take = ones + solve(memo, prefix, index + carpetLen, chs, numCarpets - 1, carpetLen);  
        // or dont 
        int dont = solve(memo, prefix, index + 1, chs, numCarpets, carpetLen);  
        // return max of both
        return memo[index][numCarpets] = Math.max(take, dont);  
    }
}