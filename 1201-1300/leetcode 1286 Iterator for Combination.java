// leetcode 1286 Iterator for Combination

/*
time: O(n)
space: O(n)
*/

class CombinationIterator {

    // stack to store the characters leading to the creation of a single combination
    Stack<Character> stack; 
    // map to store character to index
    Map<Character, Integer> ch2Idx; 
    // str - same as characters. res -- the res string representing a combination
    String res, str; 
    // same as combinationLength
    int combLength; 
 
    public CombinationIterator(String characters, int combinationLength) {
        combLength = combinationLength;
        ch2Idx = new HashMap<>();
        str = characters;
        stack = new Stack<>();
        res = "";
        // create the first combination
        for (char ch : characters.toCharArray()) {
            stack.push(ch);
            res = res + ch;
            if (stack.size() == combinationLength) break;
        }
        int idx = 0;
        // set up the mapping between character --> index
        for (char ch : characters.toCharArray()) {
            ch2Idx.put(ch, idx++);
        }
    }
    
    public String next() {
        String currRes = res;
        // process the next res
      
        int idx = str.length() - 1;
        // keep on removing the last character from the stack/res till the position where idx can be moved ahead
        while (!stack.isEmpty() && ch2Idx.get(stack.peek()) == idx) {
            stack.pop();
            idx--;
            res = res.substring(0, res.length() - 1);  
        }
        if (stack.isEmpty()) return currRes; // there is no next res to pre-process
        
        idx = ch2Idx.get(stack.pop()); // we need to add elements after this idx
        res = res.substring(0, res.length() - 1);
        
        while (stack.size()!=combLength) {
            Character temp = str.charAt(++idx);
            res += temp;
            stack.push(temp);
        }
        
        return currRes;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

