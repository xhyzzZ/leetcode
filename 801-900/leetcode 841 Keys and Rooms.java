// leetcode 841 Keys and Rooms

/*
time: O(n + e)
space: O(n)
*/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(0, rooms, visited);
        return visited.size() == rooms.size();
    }

    private void dfs(int room, List<List<Integer>> rooms, Set<Integer> visited) {
        visited.add(room);
        for (int key : rooms.get(room)) {
            if (!visited.contains(key)) dfs(key, rooms, visited);
        }
        return;
    }
}