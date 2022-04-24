// leetcode 2224 Minimum Number of Operations to Convert Time

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int convertTime(String current, String correct) {
        int diff = min(correct) - min(current), ops[] = {60, 15, 5, 1}, res = 0;
        for (int i = 0; i < ops.length && diff > 0; diff = diff % ops[i++]) res += diff / ops[i];
        return res;
    }

    private int min (String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}