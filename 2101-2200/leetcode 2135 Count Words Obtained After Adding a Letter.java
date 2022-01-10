// leetcode 2135 Count Words Obtained After Adding a Letter

/*
time: O(S * m + T * n)
space: O(S * m + T * n)
*/

class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Map<Integer, Set<String>> groups = new HashMap<>();
        for (String start : startWords) {
            char[] ca = getHash(start);
            groups.computeIfAbsent(start.length(), s -> new HashSet<>()).add(String.valueOf(ca));
        }
        int cnt = 0;
        outer:
        for (String target : targetWords) {
            int sz = target.length() - 1;
            char[] ca = getHash(target);
            for (char c : target.toCharArray()) {
                ca[c - 'a']--;
                if (groups.containsKey(sz) && groups.get(sz).contains(String.valueOf(ca))) {
                    cnt++;
                    continue outer;
                }
                ca[c - 'a']++;
            }
        }
        return cnt;
    }

    private char[] getHash(String word) {
        char[] ca = new char[26];
        for (char c : word.toCharArray()) {
            ca[c - 'a']++;
        }
        return ca;
    }
}