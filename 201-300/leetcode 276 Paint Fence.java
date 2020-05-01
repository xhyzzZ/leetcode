//leetcode 276 Paint Fence

/*
time: O()
space: O()
*/

class Solution {
    public int numWays(int n, int k) {
        // if there are no posts, there are no ways to paint them
        if (n == 0) return 0;  
        // if there is only one post, there are k ways to paint it
        if (n == 1) return k;
        // if there are only two posts, you can't make a triplet, so you 
        // are free to paint however you want.
        // first post, k options. second post, k options
        if (n == 2) return k * k;
        int table[] = new int[n + 1];
        table[0] = 0;
        table[1] = k;
        table[2] = k * k;
        for (int i = 3; i <= n; i++) {
            // the recursive formula that we derived
            table[i] = (table[i - 1] + table[i - 2]) * (k - 1);
        }
        return table[n];
    }
}