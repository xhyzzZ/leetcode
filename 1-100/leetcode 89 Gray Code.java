//leetcode 89 Gray Code


/*
time: O(1 << n)
space: O(1 << n)
*/
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < 1 << n; i++) {
        	res.add(i ^ i >> 1);
        }
        return res;
    }
}