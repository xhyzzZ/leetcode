// leetcode 1950 Maximum of Minimum Values in All Subarrays

/*
time: O(n)
space: O(n)
*/

// For each value a[i], note down the index of value < it on the left and right side, keep them in left and right arrays
// Then a[i] is the min value between len = left[i] + 1... right[i] - 1
// We update res[len] to be a[i] if a[i] is bigger. The reason is a[i] is the mininum value in a subarray of length = len
// Note a[i] will also be a potential max value for subarrays length between 1...len, as long as the subarray contains a[i]:

class Solution {
    public int[] findMaximums(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            process(deque, right, nums, i);
        }
        deque.clear();
        int[] left = new int[n];
        Arrays.fill(left, -1);
        for (int i = n - 1; i >= 0; i--) {
            process(deque, left, nums, i);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            res[len - 1] = Math.max(res[len - 1], nums[i]);           
        }
        for (int i = n - 2; i >= 0; i--) {
            res[i] = Math.max(res[i], res[i + 1]);
        }
        return res;
    }

    private void process(Deque<Integer> deque, int[] pos, int[] nums, int i) {
        while (!deque.isEmpty() && nums[deque.peek()] > nums[i]) {
            pos[deque.peek()] = i;
            deque.pop();
        }
        deque.push(i);
    }
}