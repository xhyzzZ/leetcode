// leetcode 1455 Check If a Word Occurs As a Prefix of Any Word in a Sentence

/*
time: O()
space: O()
*/

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] parts = sentence.split(" ");
        for (int i = 0; i < parts.length; i++) {
            String word = parts[i];
            if (word.startsWith(searchWord)) return i + 1;
        }
        return -1;
    }
}