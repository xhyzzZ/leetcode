// leetcode 1296 Divide Array in Sets of K Consecutive Numbers

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        int time = 0;
        
        boolean flag = false;
        while (list.size() != 0) {
            int first = list.get(0);
            list.remove(new Integer(first));
            for (int i = 1; i < k; i++) {
                if (list.contains(first + i)) {
                    list.remove(new Integer(first + i));
                } else {
                    flag = true;
                }
            }
            if (flag) {
                return false;
            }
            time++;
        }
        if (time == nums.length / k) return true;
        else return false;
    }
}