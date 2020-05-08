// leetcode 1389 Create Target Array in the Given Order

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int len = index.length;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int place = index[i];
            temp.add(place, nums[i]);
        }
        int[] res = new int[len];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
}