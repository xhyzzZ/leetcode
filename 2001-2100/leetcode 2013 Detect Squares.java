// leetcode 2013 Detect Squares

/*
time: O(n)
space: O(n)
*/

class DetectSquares {
    // Save all coordinates to a list, in the meanwhile count the 
    // frequencies of each coordinate in a hashmap
    // During count method, check if each coordinate form a square diagnol with the query point, 
    // if so, use the counts of the other two coordinates of the square to calculate the total
    List<int[]> coordinates;
    Map<String, Integer> counts;
    
    public DetectSquares() {
        coordinates = new ArrayList<>();
        counts = new HashMap<>();
    }
    
    public void add(int[] point) {
        coordinates.add(point);
        String key = point[0] + "@" + point[1];
        counts.put(key, counts.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) {
        int sum = 0, px = point[0], py = point[1];
        for (int[] coordinate : coordinates) {
            int x = coordinate[0], y = coordinate[1];
            if (px == x || py == y || (Math.abs(px - x) != Math.abs(py - y))) continue;
            sum += counts.getOrDefault(x + "@" + py, 0) * counts.getOrDefault(px + "@" + y, 0);
        }
        
        return sum;
    }
}
