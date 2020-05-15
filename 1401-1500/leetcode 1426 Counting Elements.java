// leetcode 1426 Counting Elements

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);
        int count = 0;
        for (int x : arr) {
            if (set.contains(x + 1)) count++;
        }
        return count;
    }
}