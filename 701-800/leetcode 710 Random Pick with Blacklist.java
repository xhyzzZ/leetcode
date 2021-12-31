// leetcode 710 Random Pick with Blacklist

/*
time: O(B)
space: O(1)
*/

class Solution {
    // N: [0, N)
    // B: blacklist
    // B1: < N
    // B2: >= N
    // M: N - B1
	int M;
	Random r;
	Map<Integer, Integer> map;

    public Solution(int n, int[] blacklist) {
    	map = new HashMap<>();
    	for (int b : blacklist) {
    		map.put(b, -1);
    	}    
    	M = n - map.size();

    	for (int b : blacklist) {
    		if (b < M) {
    			while (map.containsKey(n - 1)) {
    				n--;
    			}
    			map.put(b, n - 1);
    			n--;
    		}
    	}
    	r = new Random();
    }
    
    public int pick() {
        int p = r.nextInt(M);
        if (map.containsKey(p)) {
        	return map.get(p);
        }
        return p;
    }
}


/*
time: O(N)
space: O(N)
*/

class Solution {

    List<Integer> w;
    Random r;

    public Solution(int n, int[] b) {
        w = new ArrayList<>();
        r = new Random();
        Set<Integer> W = new HashSet<>();
        for (int i = 0; i < n; i++) W.add(i);
        for (int x : b) W.remove(x);
        for (int x : W) w.add(x);
    }

    public int pick() {
        return w.get(r.nextInt(w.size()));
    }
}