//leetcode 781 Rabbits in Forest

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int numRabbits(int[] answers) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
            if(map.get(answer) == answer + 1) {
                res += answer + 1;
                map.remove(answer);
            }
        }
        for(int key : map.keySet()) {
            res += key + 1;
        }
        return res;
    }
}