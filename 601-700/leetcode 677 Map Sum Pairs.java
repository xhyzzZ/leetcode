// leetcode 677 Map Sum Pairs

/*
time: O(k)
space: O(1)
*/

class TrieNode{
	TrieNode[] children = new TrieNode[26];
    int weight = 0;
}

class MapSum {
    private TrieNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode cur = root;
        for (char c : key.toCharArray()) {
            if (cur.children[c -'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }  
            cur = cur.children[c -'a'];
        }
        cur.weight = val;
    }
    
    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) return 0;
            curr = curr.children[c - 'a'];
        }
        return dfs(curr);
    }

    private int dfs(TrieNode node) {
        int sum = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.children[c - 'a'] != null) {
                sum += dfs(node.children[c - 'a']);
            }
        }
        return sum + node.weight;
    }
}