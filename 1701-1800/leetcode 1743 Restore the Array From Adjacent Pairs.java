// leetcode 1743 Restore the Array From Adjacent Pairs

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] pair : adjacentPairs) { // Loop through the input and build the corresponding graph. 
            adj.computeIfAbsent(pair[0], l -> new ArrayList<>()).add(pair[1]);
            adj.computeIfAbsent(pair[1], s -> new ArrayList<>()).add(pair[0]);
        } 
        int n = adjacentPairs.length + 1, prev = -1, k = 0; // prev is initialized as a dummy value.
        int[] ans = new int[n];
        for (var e : adj.entrySet()) {
            if (e.getValue().size() == 1) { // locate an end.
                ans[0] = e.getKey(); // start from the end. 
                break;
            }
        }
        while (k < n - 1) {
            for (int next : adj.remove(ans[k])) { // locate the corresponding pair.
                if (next != prev) { // Not the already found neighbor?
                    prev = ans[k]; // prev pointer move to current element.
                    ans[++k] = next; // save next element.  
                    break;
                }
            }
        }
        return ans;
    }
}