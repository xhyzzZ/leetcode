// leetcode 1188 Design Bounded Blocking Queue

/*
time: O()
space: O()
*/

class BoundedBlockingQueue {
    private Deque<Integer> deque;
    private int size;
    private Object lock;
    public BoundedBlockingQueue(int capacity) {
        deque = new LinkedList<>();
        size = capacity;
        lock = new Object();
    }
    
    public void enqueue(int element) throws InterruptedException {
        synchronized(lock) {
            while (deque.size() == size) lock.wait();
            deque.addLast(element);
            lock.notify();
        }
    }
    
    public int dequeue() throws InterruptedException {
        int val = 0;
        synchronized(lock) {
            while (deque.isEmpty()) lock.wait();
            val = deque.removeFirst();
            lock.notify();
        }
        return val;
    }
    
    public int size() {
        return deque.size();
    }
}