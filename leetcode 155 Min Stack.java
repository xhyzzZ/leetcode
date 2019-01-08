//leetcode 155 Min Stack

public class MinStack {
	Stack<Integer> stack, min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(min.empty()) min.push(x);
        else if(min.peek() >= x) min.push(x);
    }
    
    public void pop() {
        int popped = stack.pop();
        if(!min.empty() && min.peek() == popped) {
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
