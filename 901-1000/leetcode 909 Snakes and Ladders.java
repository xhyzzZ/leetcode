// leetcode 909 Snakes and Ladders

/*
time: O()
space: O()
*/

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        int move = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int num = queue.poll();
                if (visited[num]) continue;
                visited[num] = true;
                if (num == n * n) return move;
                for (int k = 1; k <= 6 && num + k <= n * n; k++) {
                    int next = num + k;
                    int value = getBoardValue(board, next);
                    if (value > 0) next = value;
                    if (!visited[next]) queue.offer(next);
                }
            }
            move++;
        }
        return -1;
    }

    private int getBoardValue(int[][] board, int num) {
        int n = board.length;
        int oldRow = (num - 1) / n;
        int row = n - 1 - oldRow;
        int oldCol = (num - 1) % n;
        int col = oldRow % 2 == 0 ? oldCol : n - 1 - oldCol;
        
        return board[row][col];
    }
}