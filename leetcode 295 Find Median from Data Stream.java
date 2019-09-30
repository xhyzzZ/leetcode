//leetcode 295 Find Median from Data Stream

/*
time: O(nlogn)
space: O(1)
I keep two heaps (or priority queues):

Max-heap small has the smaller half of the numbers.
Min-heap large has the larger half of the numbers.
*/
class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> (b - a));
        large = new PriorityQueue<>();
        even = true;
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
}