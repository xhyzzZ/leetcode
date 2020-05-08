// leetcode 1381 Design a Stack With Increment Operation

/*
time: O()
space: O()
*/

class CustomStack {
    List<Integer> stk;
    int size;
    public CustomStack(int maxSize) {
        stk = new ArrayList<>();
        size = maxSize;
    }
    
    public void push(int x) {
        if (stk.size() < size) {
            stk.add(x);
        }
    }
    
    public int pop() {
        return stk.isEmpty() ? -1 : stk.remove(stk.size() - 1);
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < k && i < stk.size(); i++) {
            stk.set(i, stk.get(i) + val);            
        }
    }
}