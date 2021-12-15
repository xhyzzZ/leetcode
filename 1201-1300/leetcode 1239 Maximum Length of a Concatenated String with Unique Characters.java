// leetcode 1239 Maximum Length of a Concatenated String with Unique Characters

/*
time: O(2^n)
space: O(n)
*/

class Solution {
    private int max = 0;
    public int maxLength(List<String> arr) {
        dfs(arr, 0, "");
        return max;
    }

    private void dfs(List<String> arr, int index, String concatenatStr) {
        if (isUnique(concatenatStr)) max = Math.max(max, concatenatStr.length());
        if (index == arr.size() || !isUnique(concatenatStr)) return;
        for (int i = index; i < arr.size(); i++) {
            dfs(arr, i + 1, concatenatStr + arr.get(i));
        }
    }

    private boolean isUnique(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) map[s.charAt(i) - 'a']++;
        for (int i = 0; i < map.length; i++) if (map[i] > 1) return false;
        return true;
    }
}

