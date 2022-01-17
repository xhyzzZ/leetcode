// leetcode 254 Factor Combinations

/*
time: O(nlogn)
space: O(logn)
*/

class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
	    helper(res, new ArrayList<>(), n, 2);
	    return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> item, int n, int start) {
	    if (n <= 1) {
	        if (item.size() > 1) {
	            res.add(new ArrayList<Integer>(item));
	        }
	        return;
	    }
	    
	    for (int i = start; i <= n; i++) {
	        if (n % i == 0) {
	            item.add(i);
	            helper(res, item, n / i, i);
	            item.remove(item.size() - 1);
	        }
	    }
    }
}