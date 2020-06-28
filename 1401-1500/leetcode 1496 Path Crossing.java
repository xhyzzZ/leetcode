// leetcode 1496 Path Crossing

/*
time: O(n)
space: O(n)
*/

class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        visited.add(new String(x + "" + y));
        for (char ch : path.toCharArray()) {
            if (ch == 'N') {
                y++;
                if (!visited.add(new String(x + "" + y))) return true;
            } else if (ch == 'S') {
                y--;
                if (!visited.add(new String(x + "" + y))) return true;
            } else if (ch == 'W') {
                x++;
                if (!visited.add(new String(x + "" + y))) return true;
            } else {
                x--;
                if (!visited.add(new String(x + "" + y))) return true;
            }
        }
        return false;
    }
}