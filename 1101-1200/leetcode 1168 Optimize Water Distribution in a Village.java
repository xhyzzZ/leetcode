// leetcode 1200 Minimum Absolute Difference

/*
time: O(n)
space: O(n)
*/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
            
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == min) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);
                res.add(list);
            }
        }  
        return res;
    }
}