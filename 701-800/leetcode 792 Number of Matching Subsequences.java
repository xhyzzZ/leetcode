// leetcode 792 Number of Matching Subsequences

/*
time: O(N + S), where N <= 5*10^4 is length of string s, S <= 5000*50 is sum length of all words
space: O(M), where M <= 5000 is size of words.
*/

class Node {
    String word;
    int index;
    Node(String word, int index) {
        this.word = word;
        this.index = index;
    }
}

// We can group words into buckets by their starting character.
// Then we iterate characters c in string s, we process words in bucket[c] by trimming their starting character:
// If the word after trimming is empty -> then it's a subsequence of string s -> ans += 1.
// Else group the word after trimming into corresponding buckets by its starting character.
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Node>[] buckets = new ArrayList[26];
        for (int i = 0; i < 26; i++) buckets[i] = new ArrayList<>();
        for (String word : words) {
            char startingChar = word.charAt(0);
            buckets[startingChar -'a'].add(new Node(word, 0));
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            List<Node> curBucket = buckets[c -'a'];
            buckets[c -'a'] = new ArrayList<>();
            for (Node node : curBucket) {
                node.index += 1; // Point to next character of node.word
                if (node.index == node.word.length()) {
                    ans += 1;
                } else {
                    char startingChar = node.word.charAt(node.index);
                    buckets[startingChar - 'a'].add(node);
                }
            }
        }
        return ans;
    }
}