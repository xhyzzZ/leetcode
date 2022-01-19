// leetcode 582 Kill Process

/*
time: O(n)
space: O(n)
*/

class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); ++i) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans.add(cur);
            if (map.containsKey(cur)) {
                queue.addAll(map.get(cur));
            }
        }
        return ans;
    }
}