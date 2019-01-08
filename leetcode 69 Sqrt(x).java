//leetcode 69 Sqrt(x)

/*
time: O(logn)
space: O(1)
*/
public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        int low = 0;
        int high = x;
        while(low < high) {
        	long mid = (high - low) / 2 + low;
        	if(mid * mid == x) {
        		return (int)mid;
        	} else if(mid * mid < x) {
        		low = (int)mid + 1;
        	} else {
        		high = (int)mid - 1;
        	}
        }
        if(high * high < x) {
        	return (int)high;
        } else{
        	return (int)low;
        }
    }
}