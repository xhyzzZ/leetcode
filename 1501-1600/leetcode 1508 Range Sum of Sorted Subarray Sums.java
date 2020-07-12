// leetcode 1508 Range Sum of Sorted Subarray Sums

/*
time: O(n^2)
space: O(n)
*/

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = (int)1e9 + 7;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            list.add(sum);
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }

        Collections.sort(list);

        long res = 0;
        for (int i = left - 1; i < right; i++) {
            res += list.get(i);
        }
        
        return (int) res % mod;
    }
}