// leetcode 277 Find the Celebrity

/*
time: O(n)
space: O(1)
*/

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        // Therefore, with each call to knows(...), we can conclusively 
        // determine that exactly 1 of the people is not a celebrity!

        // The following algorithm can, therefore, be used to rule out n - 1 of the people in O(n) time. 
        // We start by guessing that 0 might be a celebrityCandidate, 
        // and then we check if 0 knows 1 (within the loop). 
        // If true, then we know 0 isn't a celebrity (they know somebody), but 1 might be. 
        // We update the celebrityCandidate variable to 1 to reflect this. 
        // Otherwise, we know 1 is not a celebrity (somebody doesn't know them), 
        // but we haven't ruled out 0, yet, so keep them as the celebrityCandidate. 
        // Whoever we kept is then asked if they know 2, and so forth.
        for (int i = 1; i < n; i++) {
        	if (knows(candidate, i)) {
        		candidate = i;
        	}
        }

        for (int i = 0; i < n; i++) {
        	if (i == candidate) continue;
        	if (!knows(i, candidate) || knows(candidate, i)) {
        		return -1;
        	}
        }
        return candidate;
    }
}