// leetcode 833 Find And Replace in String

/*
time: O(n)
space: O(n)
*/

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0 ; i < indices.length; i++) sorted.add(new int[] {indices[i], i});
        Collections.sort(sorted, Comparator.comparing(i -> -i[0]));
        for (int[] ind: sorted) {
            int i = ind[0], j = ind[1];
            String source = sources[j], target = targets[j];
            if (s.substring(i, i + source.length()).equals(source)) s = s.substring(0, i) + target + s.substring(i + source.length());
        }
        return s;
    }
}