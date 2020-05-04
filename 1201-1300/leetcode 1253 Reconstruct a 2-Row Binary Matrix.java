// leetcode 1253 Reconstruct a 2-Row Binary Matrix

/*
time: O(n)
space: O(n)
*/

class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int sum = 0;
        for (int val : colsum) {
            sum += val;
        }
        if (sum != upper + lower) {
            return res;
        }
        List<Integer> up = new ArrayList<>();
        List<Integer> low = new ArrayList<>();
        res.add(up);
        res.add(low);
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                res.get(0).add(1);
                res.get(1).add(1);
                upper--;
                lower--;
            } else if (colsum[i] == 1) {
                if (upper >= lower) {
                    res.get(0).add(1);
                    res.get(1).add(0);
                    upper--;
                } else {
                    res.get(0).add(0);
                    res.get(1).add(1);
                    lower--;
                }
            } else {
                res.get(0).add(0);
                res.get(1).add(0);
            }
        }
        if (upper != 0 || lower != 0) {
            return new ArrayList<>();
        }
        return res;
    }
}