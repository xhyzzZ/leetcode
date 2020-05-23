// leetcode 604 Design Compressed String Iterator

/*
time: O()
space: O()
*/

class StringIterator {
        
    int idx;
    String s;
    int cnt;
    Character cur;
    public StringIterator(String compressedString) {
        idx = 0;
        cnt = 0;
        s = compressedString;
        cur = null;
    }
    
    public char next() {
        if (cnt == 0) {
            if (idx >= s.length()) return ' ';
            cur = s.charAt(idx++);
            while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                cnt = 10 * cnt + (s.charAt(idx) -'0');
                idx++;
            }
        }
        cnt--;
        return cur;
    }
    
    public boolean hasNext() {
        return idx < s.length() || cnt != 0;
    }
}