// leetcode 1451 Rearrange Words in a Sentence

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    class Sentence {
        int index;
        String word;
        public Sentence(int index, String word) {
            this.index = index;
            this.word = word;
        }
    }
    
    public String arrangeWords(String text) {
        String[] parts = text.split("\\s+");
        PriorityQueue<Sentence> pq = new PriorityQueue<>((a, b) -> a.word.length() == b.word.length() ? a.index - b.index : a.word.length() - b.word.length());
        for (int i = 0; i < parts.length; i++) {
            Sentence s = new Sentence(i, parts[i].toLowerCase());
            pq.add(s);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; !pq.isEmpty(); i++) {
            sb.append(pq.poll().word);
            if (i == 0) sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            if (i != parts.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
}