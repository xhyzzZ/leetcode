//leetcode 22 Generate Parentheses


//time: O(n!)
//space: O(n)


//卡特兰数

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, n, 0, "");
        return res;
    }
    
    private void helper(List<String> res, int left, int right, String s) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) helper(res, left - 1, right + 1, s + "(");
        if (right > 0) helper(res, left, right - 1, s + ")");
    }
}