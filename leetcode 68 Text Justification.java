//leetcode 68 Text Justification


/*
time: O(n)
space: O(n)
*/
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while(index < words.length) {
        	int count = word[index].length();
        	int last = index + 1;
        	while(last < word.length) {
        		if(word[last].length() + count + 1 > maxWidth) break;
        		count += 1 + words[last].length();
        		last++;
        	}
        	StringBuilder builder = new StringBuilder();
        	builder.append(words[index]);
        	int diff = last - index - 1; //多于一个的空格
        	if(last = words.length || diff == 0) {
        		for(int i = index + 1; i < last; i++) {
        			builder.append(" ");
        			builder.append(words[i]);
        		}
        		for(int i = builder.length(); i < maxWidth; i++) {
        			builder.append(" ");
        		}
        	} else {
        		int spaces = (maxWidth - count) / diff;
        		int r = (maxWidth - count) & diff;
        		for(int i = index + 1; i < last; i++) {
        			for(k = spaces; k > 0; k--) {
        				builder.append(" ");
        			}
        			if(r > 0) {
        				builder.append(" ");
        				r--;
        			}
        			builder.append(" ");
        			builder.append(words[i]);
        		}
        	}
        	res.add(builder.toString());
        	index = last;
        }
        return res;
    }
}