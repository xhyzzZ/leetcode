//leetcode 702 Search in a Sorted Array of Unknown Size

/*
time: O(logn)
space: O(1)
To use binary search, we need to find the search space defined by low and hi. 
Find hi by moving hi exponentially. Once hi is found, low is previous hi. 
Then do binary search.
*/

class Solution {
    public int search(ArrayReader reader, int target) {
        int hi = 1;
        while (reader.get(hi) < target) {
        	hi = hi << 1;
        }
        int low = hi >> 1;
        while (low <= hi) {
        	int mid = low + (hi - low) / 2;
        	if (reader.get(mid) > target) {
        		hi = mid - 1;
        	} else if (reader.get(mid) < target) {
        		low = mid + 1;
        	} else {
        		return mid;
        	}
        }
        return -1;
    }
}