//leetcode 354 Russian Doll Envelopes

/*
time: O(nlogn)
space: O()
*/

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || 
        	envelopes[0] == null || envelopes[0].length != 2) {
        	return 0;
        }

	    Arrays.sort(envelopes, new Comparator<int[]>() {
	        public int compare(int[] arr1, int[] arr2) {
	            if (arr1[0] == arr2[0])
	                return arr2[1] - arr1[1];
	            else
	                return arr1[0] - arr2[0];
	       } 
	    });
	    int dp[] = new int[envelopes.length];
	    int res = 0;
	    for (int[] envelope : envelopes) {
	        int left = 0, right = res, mid = 0;    // right = res
	        while (left < right) {
	        	mid = (right - left) / 2 + left;
	        	if(dp[mid] < envelope[1]) left = mid + 1;
	        	else right = mid;
	        }

	       	// left is the right position to 'replace' in dp array
	        dp[left] = envelope[1];
	        //if updated subsequence is the longest one, increase result size by 1
	        if (left == res) res++;
	    }
	    return res;
    }
}