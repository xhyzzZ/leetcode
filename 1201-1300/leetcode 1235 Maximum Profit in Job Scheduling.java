// leetcode 1235 Maximum Profit in Job Scheduling

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // Sort the jobs by endTime.
        // dp[time] = profit means that within the first time duration, we cam make at most profit money.
        int len = startTime.length;
        int[][] jobs = new int[len][3];
        for (int i = 0; i < len; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        // If we don't do this job, nothing will be changed.
        // If we do this job, binary search in the dp to find the largest profit we can make before start time s.
        // Compare with last element in the dp, we make more money, it worth doing this job,
        // Otherwise, we'd like not to do this job.
        dp.put(0, 0);
        for (int[] job : jobs) {
            int cur = dp.floorEntry(job[0]).getValue() + job[2];
            if (cur > dp.lastEntry().getValue())
                dp.put(job[1], cur);
        }
        return dp.lastEntry().getValue();
    }
}