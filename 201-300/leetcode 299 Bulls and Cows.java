//leetcode 299 Bulls and Cows

/*
time: O(n)
space: O(1)
*/

class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i) - '0'] < 0) cows++;
                if (numbers[guess.charAt(i) - '0'] > 0) cows++;
                numbers[secret.charAt(i) - '0']++;
                numbers[guess.charAt(i) - '0']--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}