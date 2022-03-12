// leetcode 636 Exclusive Time of Functions

/*
time: O(n)
space: O(n)
*/

// If it is an start log, we just push to the stack
// If it is an end log, means a function call ends, 
// then the last log in the stack is the log with the same function in "start" state
// Meanwhile if the stack is not empty, means the function just finished is inside another function 
// called wrapper function, so this function's time is not counted into the wrapper function time. 
// We will decrease the time in the wrapper function in advance. 
// So when we find the end log of the wrapper function, 
// we can just calculate the whole time spent in wrapper function, 
// and decrease the time does not belongs to the wrapper function.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
	    Stack<Integer> stack = new Stack<>();
	    int prevTime = 0;
	    for (String log : logs) {
	        String[] arr = log.split(":");
	        if (arr[1].equals("start")) {
	            if (!stack.isEmpty()) res[stack.peek()] += Integer.parseInt(arr[2]) - prevTime;
	            // arr[2] is the start of next interval, doesn't belong to current interval.
	            stack.push(Integer.parseInt(arr[0]));
	            prevTime = Integer.parseInt(arr[2]);
	        } else {
	            res[stack.pop()] += Integer.parseInt(arr[2]) - prevTime + 1;
	            // arr[2] is end of current interval, belong to current interval. 
	            // That's why we have +1 here
	            prevTime = Integer.parseInt(arr[2]) + 1;
	            // prevTime means the start of next interval, so we need to +1
	        }
	    }
	    return res;
    }
}