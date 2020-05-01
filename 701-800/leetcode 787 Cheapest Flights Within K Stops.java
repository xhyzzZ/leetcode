//leetcode 787 Cheapest Flights Within K Stops

/*
time: O()
space: O()
*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        pq.add(new int[] {0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if (stops > 0) {
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[] {price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
	    final int kInfCost = 1 << 30;
	    int[] cost = new int[n];
	    Arrays.fill(cost, kInfCost);
	    cost[src] = 0;
	    
	    for (int i = 0; i <= K; ++i) {
		    int[] tmp = cost.clone();
		    for(int[] p : flights)
	        tmp[p[1]] = Math.min(tmp[p[1]], cost[p[0]] + p[2]);
	      	cost = tmp;
	    }
        return cost[dst] >= kInfCost ? -1 : cost[dst]; 
  	}
}