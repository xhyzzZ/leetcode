// leetcode 1514 Path with Maximum Probability

/*
time: O(n + Elogn)
space: O(n + E)
*/

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0], to = edges[i][1];
            map.putIfAbsent(from, new HashMap<>());
            map.putIfAbsent(to, new HashMap<>());
            map.get(from).put(to, succProb[i]);
            map.get(to).put(from, succProb[i]);
        }
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        Set<Integer> visited = new HashSet<>();
        pq.offer(new double[] {start, 1});
        
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int node = (int) cur[0];
            double prob = cur[1];
            
            if (node == end) return prob;
            if (!visited.add(node)) continue;
            
            if (map.containsKey(node)) {
                Map<Integer, Double> next = map.get(node);
                for (int key : next.keySet()) {
                    pq.offer(new double[] {key, prob * next.get(key)});
                }
            }
        }
        
        return 0;
    }
}