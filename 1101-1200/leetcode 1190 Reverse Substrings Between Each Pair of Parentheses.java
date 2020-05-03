// leetcode 1190 Reverse Substrings Between Each Pair of Parentheses

/*
time: O(n^2)
space: O(n)
*/

class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                Queue<Character> queue = new LinkedList<>();
                while (!st.isEmpty() && st.peek() != '(') queue.add(st.pop());
                if (!st.isEmpty()) st.pop();
                while (!queue.isEmpty()) st.push(queue.remove());
            } else {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pop());
        
        return sb.reverse().toString();
    }
}