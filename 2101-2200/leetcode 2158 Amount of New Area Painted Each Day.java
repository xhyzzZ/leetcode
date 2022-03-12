// leetcode 2158 Amount of New Area Painted Each Day

/*
time: O(nlogn)
space: O(n)
*/

// We iterate our wall from 0 to maxEnd (sweep line part), and perform following actions:

// At each step we check if there is any (index, enter) or (index, exit) on the wall
// If we have enter we add the index to our layers set. (which is sorted).
// Also if we have exit we remove index from our layers set.
// If there is any layer, we take the top layer and increment result for that layer by 1.
class Solution {
    public int[] amountPainted(int[][] paint) {
        int end = Arrays.stream(paint).mapToInt(p -> p[1]).max().getAsInt();
        int[] res = new int[paint.length];
        List<List<int[]>> line = new ArrayList<>(end + 1);
        for (int i = 0; i <= end; i++) line.add(new ArrayList<>());
        for (int i = 0; i < paint.length; i++) {
            line.get(paint[i][0]).add(new int[] {i, 1});
            line.get(paint[i][1]).add(new int[] {i, -1});
        }
        TreeSet<Integer> map = new TreeSet<>();
        for (List<int[]> point : line){
            for (int[] layer : point)
                if (layer[1] == 1) {
                    map.add(layer[0]);
                } else map.remove(layer[0]);
            if (!map.isEmpty()) res[map.first()]++;
        }
        return res;
    }
}