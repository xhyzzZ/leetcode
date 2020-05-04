// leetcode 1291 Sequential Digits

/*
time: O(n)
space: O(n
*/

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int len1 = String.valueOf(low).length();
        int len2 = String.valueOf(high).length();
        
        
        List<Integer> res = new ArrayList<>();
        for (int l = len1; l <= len2; l++) {
            for (int i = 1; i + l <= 10; i++) {
                StringBuilder sb = new StringBuilder();
                int len = l, s = i;
                while (len-- > 0) sb.append(s++);
                int t = Integer.valueOf(sb.toString());
                if (t >= low && t <= high) res.add(t);
            }
        }
        return res;
    }
}