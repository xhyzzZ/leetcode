// leetcode 2079 Watering Plants

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int water = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] > water) {
                res += 2 * i + 1;
                water = capacity;
            } else {
                res += 1;
            }
            water -= plants[i];
        }
        
        return res;
    }
}