// leetcode 1184 Distance Between Bus Stops

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int total = 0;
        int part = 0;
        int res = 0;
        for (int i = 0; i < distance.length; i++) {
            total += distance[i];
        }
        
        int s = 0, e = 0;
        if (start > destination) {
            s = destination;
            e = start;
        } else {
            s = start;
            e = destination;
        }
        for (int i = s; i < e; i++) {
            part += distance[i];
        }
        res = Math.min(part, total - part);
        return res;
    }
}