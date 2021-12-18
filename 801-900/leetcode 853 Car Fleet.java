// leetcode 853 Car Fleet 

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < position.length; ++i) { 
            map.put(position[i], speed[i]); 
        }
        int fleets = 0;
        double slowest = 0; // slowest fleet time to reach target.
        for (int pos : map.keySet()) { 
            // iterate starting from the fleet closest to the target.
            // time need for the car to reach the target.
            double time = (double) (target - pos) / map.get(pos); 
            // can catch up the slowest fleet ahead, merge into it.
            if (time <= slowest) continue; 
            // can NOT catch up, form a new fleet.
            fleets++;
            // update slowest fleet time.
            slowest = time; 
        }
        return fleets;
    }
}