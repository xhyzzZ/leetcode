// leetcode 1834 Single-Threaded CPU

/*
time: O(nlogn)
space: O(n)
*/


class Solution {
    public int[] getOrder(int[][] tasks) {
        int len = tasks.length;
        int[][] allTasks = new int[len][3];        
        for (int i = 0; i < len; i++) allTasks[i] = new int[] {tasks[i][0], tasks[i][1], i};

        Arrays.sort(allTasks, (a, b) -> a[0] - b[0]);

        Queue<int[]> availableTasks = new PriorityQueue<int[]>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

        int currTime = allTasks[0][0];
        int[] res = new int[len];
        int nextTaskIndex  = 0, orderIndex = 0;
        while (orderIndex < len) {
            // Add all the tasks that came in while previous was getting processed
            while (nextTaskIndex < allTasks.length && allTasks[nextTaskIndex][0] <= currTime) {
                availableTasks.add(allTasks[nextTaskIndex]);
                nextTaskIndex++;
            }

            // No tasks came in while previous was getting processed
            if (availableTasks.isEmpty()) {
                currTime = allTasks[nextTaskIndex][0];
            } else {
                int[] task = availableTasks.remove();
                res[orderIndex++] = task[2];
                currTime += task[1];
            }
        }
        
        return res;
    }
}