// leetcode 1436 Destination City

/*
time: O(n)
space: O(n)
*/

class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> outdegree = new HashMap<>();
        for (List<String> path : paths) {
            String from = path.get(0);
            String to = path.get(1);
            outdegree.put(from, outdegree.getOrDefault(from, 0) + 1);
            outdegree.putIfAbsent(to, 0);
        }
        String res = "";
        for (String key : outdegree.keySet()) {
            if (outdegree.get(key) == 0) res = key;
        }
        return res;
    }
}