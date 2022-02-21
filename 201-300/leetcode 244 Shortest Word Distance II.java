// leetcode 244 Shortest Word Distance II

/*
time: O()
space: O(N)
*/

class WordDistance {
	private Map<String, List<Integer>> map;
    // constuctor O(N) considering there were NN words in the original list
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
        	String word = words[i];
        	map.putIfAbsent(word, new ArrayList<>());
        	map.get(word).add(i);
        }
    }
    
    // time: O(max(K,L)) where K and L represent the number of occurrences of the two words.
    // However, K = O(N) and also L = O(N). Therefore, the overall time complexity would also be O(N)
    public int shortest(String word1, String word2) {
        List<Integer> is = map.get(word1), js = map.get(word2);
        int dist = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < is.size() && j < js.size(); ) {
        	int index1 = is.get(i), index2 = js.get(j);
        	dist = Math.min(dist, Math.abs(index1 - index2));
        	if (index1 < index2) {
        		i++;
        	} else {
        		j++;
        	}
        }
        return dist;
    }
}