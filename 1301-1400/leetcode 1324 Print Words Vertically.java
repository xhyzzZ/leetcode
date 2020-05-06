// leetcode 1324 Print Words Vertically

/*
time: O(mn)
space: O(n)
*/

class Solution {
    public List<String> printVertically(String s) {
        String[] parts = s.trim().split(" ");
        int maxLen = 0;
        for (String c : parts) {
            int len = c.length();
            maxLen = Math.max(maxLen, len);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();
            for (String c : parts) {
                if (i >= c.length()) {
                    sb.append(" ");
                } else {
                    sb.append(c.charAt(i));
                }
            }
            String newString = sb.toString().replaceFirst("\\s++$", "");
            res.add(newString);
        }
        return res;
    }
}