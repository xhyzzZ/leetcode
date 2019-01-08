//leetcode 163 Missing Ranges


/*
time: O()
space: O()
*/
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int i : nums) {
        	if(i > lower) res.add(lower + ((i - 1 > lower) ? "->" + (i - 1) : ""));
        	if(i == upper) return res;
        	lower = i + 1;
        }
        if(lower <= upper) res.add(lower + ((upper > lower) ? "->" + (upper) : ""));
        return res;
    }
}