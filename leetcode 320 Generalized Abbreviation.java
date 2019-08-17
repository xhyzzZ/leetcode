//leetcode 320 Generalized Abbreviation

/*
time: O(n)
space: O(h)
*/

public class Solution {
	public List<String> generateAbbreviations(String word) {
		List<String> list = new ArrayList<>();
		dfs(list, new StringBuilder(), word.toCharArray(), 0, 0);
		return list;
	}

	private void dfs(List<String> list, StringBuilder sb, char[] word, int index, int curNum) {
		int len = sb.length();
		if (index == word.length) {
			if (curNum != 0) sb.append(curNum);
			list.add(sb.toString());
		} else {
			// Don't add, merge to current number
			dfs(list, sb, word, index + 1, curNum + 1);
			// Add current char
			if(curNum != 0) sb.append(curNum);
			dfs(list, sb.append(word[index]), word, index + 1, 0);
		}
		sb.setLength(len);
	}
}