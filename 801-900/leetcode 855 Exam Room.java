// leetcode 855 Exam Room

/*
time: O(n)
space: O()

Very straight forward idea.
Use a list seat to record the index of seats where people sit.

seat():
1. find the biggest distance at the start, at the end and in the middle.
2. insert index of seat
3. return index

leave(p): pop out p
*/

class ExamRoom {
    private int n;
    private List<Integer> seat;

    public ExamRoom(int n) {
        seat = new ArrayList<>();
        this.n = n;
    }

    public int seat() {
        if (seat.size() == 0) {
            seat.add(0);
            return 0;
        }
        int d = Math.max(seat.get(0), this.n - 1 - seat.get(seat.size() - 1));
        for (int i = 0; i < seat.size() - 1; ++i) d = Math.max(d, (seat.get(i + 1) - seat.get(i)) / 2);
        if (seat.get(0) == d) {
            seat.add(0, 0);
            return 0;
        }
        for (int i = 0; i < seat.size() - 1; ++i)
            if ((seat.get(i + 1) - seat.get(i)) / 2 == d) {
                seat.add(i + 1, (seat.get(i + 1) + seat.get(i)) / 2);
                return seat.get(i + 1);
            }
        seat.add(this.n - 1);
        return this.n - 1;
    }

    public void leave(int p) {
        for (int i = 0; i < seat.size(); ++i) if (seat.get(i) == p) seat.remove(i);
    }
}