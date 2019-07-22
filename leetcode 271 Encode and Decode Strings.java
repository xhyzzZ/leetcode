//leetcode 271 Encode and Decode Strings

/*
time: O(n)
space: O(1)
*/

public class Codec {
  // Encodes a list of strings to a single string.
  	public String encode(List<String> strs) {
	    StringBuffer out = new StringBuffer();
	    for (String s : strs)
	        out.append(s.replace("#", "##")).append(" # ");
	    return out.toString();
	}

	public List<String> decode(String s) {
	    List strs = new ArrayList();
	    String[] array = s.split(" # ", -1);
	    for (int i = 0; i < array.length - 1; ++i) {
	        strs.add(array[i].replace("##", "#"));
	    }
	    return strs;
	}
}
