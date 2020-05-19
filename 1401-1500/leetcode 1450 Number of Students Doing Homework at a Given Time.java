// leetcode 1450 Number of Students Doing Homework at a Given Time

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) count++;
        }
        return count;
    }
}