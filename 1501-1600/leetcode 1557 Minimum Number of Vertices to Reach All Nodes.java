// leetcode 1557 Minimum Number of Vertices to Reach All Nodes

/*
time: O(n)
space: O(n)
*/

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        
        boolean[] inDegree = new boolean[n];
        
        for (List<Integer> edge : edges) inDegree[edge.get(1)] = true;
        
        for (int i = 0; i < n; i++) {
            if (!inDegree[i]) res.add(i);
        }
        
        return res;
    }
}