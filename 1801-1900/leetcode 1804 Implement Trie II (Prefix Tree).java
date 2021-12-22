// leetcode 1804 Implement Trie II (Prefix Tree)

/*
time: O(l)
l单词长度
space: O(n * l^2)
*/

class TrieNode {
    // k - number of instances, n - number of all strings, k<=n
    int k;
    int n;
    TrieNode[] children;
    
    // Initialize your data structure here.
    public TrieNode() {
        this.k = 0;
        this.n = 0;
        this.children = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode runner = root;
        for (char c : word.toCharArray()) {
            if (runner.children[c - 'a'] == null) runner.children[c - 'a'] = new TrieNode();
            runner = runner.children[c - 'a'];
            runner.n++;
        }
        runner.k++;
    }
    
    public int countWordsEqualTo(String word) {
        return find(word).k;
    }
    
    public int countWordsStartingWith(String prefix) {
        return find(prefix).n;
    }
    
    public void erase(String word) {
        TrieNode runner = root;
        for (int i = 0; i < word.length(); i++, runner.n--) runner = runner.children[word.charAt(i) - 'a'];
        runner.k--;
    }

    private TrieNode find(String word) {
        TrieNode runner = root;
        for (int i = 0; i < word.length() && runner != null; i++) runner = runner.children[word.charAt(i) - 'a'];
        return runner != null ? runner : new TrieNode();
    }
}