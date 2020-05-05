// leetcode 1311 Get Watched Videos by Your Friends

/*
time: O()
space: O()
*/

class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> f = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        visited.add(id);
        while (!queue.isEmpty()) {
            if (level == 0) {
                while (!queue.isEmpty()) {
                    f.add(queue.poll());
                }
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int node : friends[cur]) {
                    if (!visited.contains(node)) {
                        queue.add(node);
                        visited.add(node);
                    }
                }
            }
            level--;
        }
        List<String> res = new ArrayList<>();
        Map<String, Integer> freq = new HashMap<>();
        for (int index : f) {
            for (String c : watchedVideos.get(index)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }
        				
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue());
        pq.addAll(freq.entrySet());
				
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            res.add((String) e.getKey());
        }
        return res;
    }
}