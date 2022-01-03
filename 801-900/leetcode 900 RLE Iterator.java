// leetcode 900 RLE Iterator

/*
time: O(n)
space: O(1)
*/

class RLEIterator {

    private int[] encoding;
    private int index;
    
    public RLEIterator0(int[] encoding) {
        this.encoding = encoding; // Injected encoding[]
    }
    
    public int next(int n) {
        while (index < encoding.length) { // all elements exhausted?
            if (n <= encoding[index]) { // find the corresponding value.
                encoding[index] -= n; // deduct n from encoding[index].
                return encoding[index + 1]; // encoding[index + 1] is the nth value.
            }
            n -= encoding[index]; // not find the value yet, deduct encoding[index] from n.
            index += 2; // next group of same values.
        }
        return -1; // not enough values remaining.
    }
}
