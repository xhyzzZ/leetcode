// leetcode 216 Combination Sum III

/*
time: O(9! * k / (9 - k)!)
space: O(k)
*/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
	    List<List<Integer>> ans = new ArrayList<>();
	    helper(ans, new ArrayList<Integer>(), k, 1, n);
	    return ans;
	}

	private void helper(List<List<Integer>> ans, List<Integer> list, int k,  int start, int target) {
		if (list.size() == k && target == 0) {
			ans.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = start; i <= 9; i++) {
			list.add(i);
			helper(ans, list, k, i + 1, target - i);
			list.remove(list.size() - 1);
		}
	}
}

