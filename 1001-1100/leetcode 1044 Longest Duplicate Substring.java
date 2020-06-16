// leetcode 1044 Longest Duplicate Substring

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
  	public String longestDupSubstring(String S) {
	    int n = S.length();
	    // convert string to array of integers
	    // to implement constant time slice
	    int[] nums = new int[n];
	    for (int i = 0; i < n; ++i) nums[i] = (int) S.charAt(i) - (int) 'a';
	    // base value for the rolling hash function
	    int a = 26;
	    // modulus value for the rolling hash function to avoid overflow
	    long modulus = (long) Math.pow(2, 32);

	    // binary search, L = repeating string length
	    int left = 1, right = n;
	    int mid;
	    while (left <= right) {
	      	mid = left + (right - left) / 2;
	      	if (search(mid, a, modulus, n, nums) != -1) left = mid + 1;
	      	else right = mid - 1;
	    }

	    int start = search(left - 1, a, modulus, n, nums);
	    return S.substring(start, start + left - 1);
	}

	/*
	Rabin-Karp with polynomial rolling hash.
	Search a substring of given length that occurs at least 2 times.
	Return start position if the substring exits and -1 otherwise.
	*/
	private int search(int mid, int a, long modulus, int n, int[] nums) {
	  	// compute the hash of string S[:mid]
	    long h = 0;
	    for (int i = 0; i < mid; ++i) h = (h * a + nums[i]) % modulus;

	    // already seen hashes of strings of length mid
	    HashSet<Long> seen = new HashSet<>();
	    seen.add(h);
	    // const value to be used often : a**mid % modulus
	    long aL = 1;
	    for (int i = 1; i <= mid; ++i) aL = (aL * a) % modulus;

	    for (int start = 1; start < n - mid + 1; ++start) {
	      	// compute rolling hash in O(1) time
	    	h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
	      	h = (h + nums[start + mid - 1]) % modulus;
	      	if (seen.contains(h)) return start;
	      	seen.add(h);
	    }
	    return -1;
	}
}