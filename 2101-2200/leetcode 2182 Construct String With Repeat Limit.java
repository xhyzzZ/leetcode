// leetcode 2182 Construct String With Repeat Limit

/*
time: O(n)
space: O(1)
*/

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) pq.add(new int[] {i, freq[i]});
        }
        
        while (!pq.isEmpty()) {
            // We first poll from the PQ, get the char cloest to 'z'
            int[] cur = pq.poll(); 
            char ch = (char) (cur[0] + 'a');
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != ch) {
                int count = cur[1];
                int k = repeatLimit;
                // Cannot use same char more than limit in a row
                while (k-- > 0 && count-- > 0) sb.append(ch);
                if (count > 0) {
                    pq.offer(new int[] {cur[0], count});
                }
            } else {
                /**
                If the current ending char is what we poll from PQ
                We need a different char, cause we cannot use same char in a row.
                */
                if (pq.size() == 0) break; // if there is no more chars, stop
                int[] cur2 = pq.poll();
                sb.append((char) (cur2[0] + 'a'));
                
                int count2 = cur2[1];
                count2--;
                if (count2 > 0) {
                    pq.offer(new int[] {cur2[0], count2});
                }
                pq.offer(cur); // Remember to put the first polled Tuple back.
            }
        }
        return sb.toString();
    }
}