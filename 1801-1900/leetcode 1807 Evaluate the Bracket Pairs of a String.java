// leetcode 1807 Evaluate the Bracket Pairs of a String

/*
time: O(n)
space: O(n)
*/

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for (List<String> list : knowledge) map.put(list.get(0), list.get(1));

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != '(') sb.append(s.charAt(i++));

            if (i == s.length()) return sb.toString();
            
            int start = i + 1; // store the index after '('
            while (s.charAt(i) != ')') i++; // find the closing bracket ')'
            String key = s.substring(start, i++); // make key
            sb.append(map.getOrDefault(key, "?")); // add value to res
        }
        return sb.toString();
    }
}