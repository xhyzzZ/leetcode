// leetcode 244 Shortest Word Distance II

/*
time: O(m + n)
space: O()
*/

class WordDistance {
	private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
        	String word = words[i];
        	map.putIfAbsent(word, new ArrayList<>());
        	map.get(word).add(i);
        }
    }
    
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