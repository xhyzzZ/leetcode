// leetcode 1408 String Matching in an Array

/*
time: O(n^2)
space: O(n)
*/

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                String word = words[j];
                if (word.indexOf(words[i]) != -1) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}