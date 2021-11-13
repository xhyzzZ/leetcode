// leetcode 1834 Single-Threaded CPU

/*
time: O(nlogn)
space: O(n)
*/


class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] allTasks = new int[tasks.length][3];        
        for (int i = 0; i < tasks.length; i++)
            allTasks[i] = new int[]{ tasks[i][0], tasks[i][1], i };

        Arrays.sort(allTasks, (a, b) -> a[0] - b[0]);

        Queue<int[]> availableTasks = new PriorityQueue<int[]>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

        int currTime = allTasks[0][0];
        int[] res = new int[tasks.length];
        int read = 0, write = 0;
        while (write < res.length) {
            while (read < allTasks.length && allTasks[read][0] <= currTime) {
                availableTasks.add(allTasks[read]);
                read++;
            }

            if (availableTasks.isEmpty()) {
                currTime = allTasks[read][0];
            } else {
                int[] task = availableTasks.remove();
                res[write++] = task[2];
                currTime += task[1];
            }
        }
        
        return res;
    }
}