// leetcode 954 Array of Doubled Pairs

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new HashMap();
        for (int x : arr) count.put(x, count.getOrDefault(x, 0) + 1);

        // B = arr as Integer[], sorted by absolute value
        Integer[] B = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) B[i] = arr[i];
        Arrays.sort(B, Comparator.comparingInt(Math::abs));

        for (int x : B) {
            // If this can't be consumed, skip
            if (count.get(x) == 0) continue;
            // If this doesn't have a doubled partner, the answer is false
            if (count.getOrDefault(2 * x, 0) <= 0) return false;

            // Write x, 2 * x
            count.put(x, count.get(x) - 1);
            count.put(2 * x, count.get(2 * x) - 1);
        }

        // If we have written everything, the answer is true
        return true;
    }
}