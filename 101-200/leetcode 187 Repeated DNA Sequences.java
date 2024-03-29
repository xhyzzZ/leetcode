// leetcode 187 Repeated DNA Sequences

/*
time: O()
space: O()
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
	    Set<Integer> words = new HashSet<>();
	    Set<Integer> doubleWords = new HashSet<>();
	    List<String> rv = new ArrayList<>();
	    char[] map = new char[26];
	    // map['A' - 'A'] = 0;
	    map['C' - 'A'] = 1;
	    map['G' - 'A'] = 2;
	    map['T' - 'A'] = 3;

	    for (int i = 0; i < s.length() - 9; i++) {
	        int v = 0;
	        for (int j = i; j < i + 10; j++) {
	        	// move v left 2 bit, for example 01 after moving 0100
	            v <<= 2;
	            // Append 2 bits, 0100 | 11 => 0111
	            v |= map[s.charAt(j) - 'A'];
	        }
	        if (!words.add(v) && doubleWords.add(v)) {
	            rv.add(s.substring(i, i + 10));
	        }
	    }
	    return rv;
	}
}
