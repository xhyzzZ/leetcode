// leetcode 1268 Search Suggestions System

/* 
time: O(m) to build the trie where M is total number of characters in products
space: O(26n)
*/

class Solution {
    
    class Trie {
        Trie[] sub = new Trie[26];
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (String product : products) { // build Trie.
            Trie t = root;
            for (char c : product.toCharArray()) { // insert current product into Trie.
                if (t.sub[c - 'a'] == null)
                    t.sub[c - 'a'] = new Trie();
                t = t.sub[c - 'a'];
                t.pq.offer(product); // put products with same prefix into PriorityQueue.
                if (t.pq.size() > 3) // maintain 3 lexicographically minimum strings.
                    t.pq.poll();
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Trie t = root;
        for (char c : searchWord.toCharArray()) { // search product.
            List<String> l = new ArrayList<>();
            if (t != null) // if there exist products with current prefix.
                t = t.sub[c - 'a'];
            if (t != null) { // if there exist products with current prefix.
                l.addAll(t.pq);
                Collections.sort(l); // sort products.
            }
            ans.add(l);
        }
        return ans;
    } 
}