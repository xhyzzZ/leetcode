// leetcode 1441 Build an Array With Stack Operations

/*
time: O(n)
space: O(n)
*/

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int k = 1;  // k is a tracker that track the number that start from 1 to n.
        for (int i = 0; i < target.length; i++) {
            if (target[i] == k) { // there is no missing number for current value of k. Then we just do a 'Push' operation.
                res.add("Push");
            } else { // if there is a missing number, we need to keep i unmoved until we handle all the missing numbers!
                i--;
                res.add("Push");
                res.add("Pop");
            }
            k++;
        }
        return res;
    }
}