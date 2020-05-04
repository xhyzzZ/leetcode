// leetcode 1282 Group the People Given the Group Size They Belong To

/*
time: O(n)
space: O(n)
*/

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (map.containsKey(size)) {
                map.get(size).add(i);
            } else {
                map.put(size, new ArrayList<>());
                map.get(size).add(i);
            }
        }
        
        for (int key : map.keySet()) {
            List<Integer> index = map.get(key);
            List<Integer> temp = new ArrayList<>();
            int number = map.get(key).size() / key;
            int start = 0;
            for (int i = 0; i < number; i++) {
                temp = index.subList(start, start + key);
                start = start + key;
                res.add(temp);
            }
        }
        return res;
    }
}