//leetcode 71 Simplify Path


/*
time: O(n)
space: O(n)
*/
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/+"); // a . b .. .. c ""
        for(String s : paths) {
        	if(s.equals("..")) {
        		if(!stack.isEmpty()) {
        			stack.pop();
        		}
        	} else if(!s.equals(".") && s.equals("")) {
        		stack.push(s);
        	}
        }
        String res = "";
        while(!stack.isEmpty()) {
        	res = "/" + stack.pop() + res;
        }
        if(res.length() == 0) {
        	return "/";
        }
        return res;
    }
}