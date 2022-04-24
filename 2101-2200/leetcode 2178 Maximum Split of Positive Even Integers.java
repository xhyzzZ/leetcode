// leetcode 2178 Maximum Split of Positive Even Integers

/*
time: O(n ^ 0.5)
space: O(m)
*/

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        LinkedList<Long> res = new LinkedList<>();
        if (finalSum % 2 == 0) {
            long i = 2;
            while (i <= finalSum) {
                res.offer(i);
                finalSum -= i;
                i += 2;
            } 
            res.offer(finalSum + res.pollLast());
        }
        return res;
    }
}