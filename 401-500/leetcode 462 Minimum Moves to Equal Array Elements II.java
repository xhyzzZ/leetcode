// leetcode 462 Minimum Moves to Equal Array Elements II

/*
time: O(nlogn)
space: O(1)
*/

sort
public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(nums[nums.length / 2] - num);
        }
        return sum;
    }
}

/*
time: avergae O(n) worst case O(n^2)
space: O(1)
*/

quick select
public class Solution {
    public int minMoves2(int[] nums) {
        int sum = 0;
        int median = select(nums, 0, nums.length - 1, nums.length / 2);

        for (int num : nums) {
            sum += Math.abs(median - num);
        }
        return sum;
    }

    private void swap(int[] list, int i, int pivot) {
        int temp = list[i];
        list[i] = list[pivot];
        list[pivot] = temp;
    }

    private int partition(int[] list, int left, int right) {
        int pivotValue = list[right];
        int i = left;
        for (int j = left; j <= right; j++) {
            if (list[j] < pivotValue) {
                swap(list, i, j);
                i++;
            }
        }
        swap(list, right, i);
        return i;
    }

    private int select(int[] list, int left, int right, int k) {
        if (left == right) return list[left];
        int pivotIndex = partition(list, left, right);
        if (k == pivotIndex) {
            return list[k];
        } else if (k < pivotIndex) {
            return select(list, left, pivotIndex - 1, k);
        } else {
            return select(list, pivotIndex + 1, right, k);
        }
    }
}