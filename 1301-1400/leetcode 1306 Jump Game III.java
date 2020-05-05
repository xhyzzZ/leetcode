// leetcode 1306 Jump Game III

/*
time: O()
space: O()
*/

class Solution {
    public boolean canReach(int[] arr, int start) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        set.add(start);
        boolean mark = false;
        while (!queue.isEmpty()) {
            int val = queue.poll();
            int left = val + arr[val];
            int right = val - arr[val];
            if (arr[val] != 0) {
                if (left >= 0 && left < arr.length && !set.contains(left)) {
                    queue.add(left);
                    set.add(left);
                }
                if (right >= 0 && right < arr.length && !set.contains(right)) {
                    queue.add(right);
                    set.add(right);
                }
            } else {
                mark = true;
                break;
            }
        }
        return mark;
    }
}