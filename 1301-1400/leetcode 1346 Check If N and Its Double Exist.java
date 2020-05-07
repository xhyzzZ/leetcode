// leetcode 1346 Check If N and Its Double Exist

/*
time: O(n^2)
space: O(1)
*/

class Solution {
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    if (arr[i] == 2 * arr[j]) return true;
                }
            }
        }
        return false;
    }
}