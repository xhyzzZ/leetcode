//leetcode 186 Reverse Words in a String II

/*
time: O(n)
space: O(h)
*/

public class Solution {
	public void reverseWords(char[] s){
		reverseWords(s, 0, s.length - 1);
		for (int i = 0, j = 0; i <= s.length; i++) {
			if (i == s.length || s[i] == ' ') {
				reverseWords(s, j, i - 1);
				j = i + 1;
			}
		}
	}

	private void reverseWords(char[] s, int begin, int end) {
		while(begin < end) {
			char c = s[begin];
			s[begin] = s[end];
			s[end] = c;
			begin++;
			end--;
		}
	}
}


public class Solution {
	public void reverseWords(char[] s) {
		int wordStart = 0;
		int index = 0;
		while (index < s.length) {
			while (index < s.length && s[index] != ' ') index++;
			reverse(s, wordStart, index - 1);
			index ++;
			wordStart = index;
		}
		reverse(s, 0, s.length - 1);
	}
	
	private void reverse(char[] s, int start, int end) {
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start ++;
			end--;
		}
	}
}