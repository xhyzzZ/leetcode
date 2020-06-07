// leetcode 1172 Dinner Plate Stacks

/*
time: O()
space: O()
*/

class DinnerPlates {
    Map<Integer, Stack<Integer>> map; //index - stack
    int popIndex, pushIndex, capacity;
    public DinnerPlates(int capacity) {
        this.map = new HashMap<>();
        this.pushIndex = 0;
        this.popIndex = 0;
        this.capacity = capacity;
        map.put(pushIndex, new Stack<>());
    }
    
    public void push(int val) {
    	//use while here for it could be all full because of popAtStack
        while (map.containsKey(pushIndex) && map.get(pushIndex).size() == capacity) pushIndex++;  
        if (!map.containsKey(pushIndex)) map.put(pushIndex, new Stack<>());
        map.get(pushIndex).push(val);
        popIndex = Math.max(popIndex, pushIndex);//pop should be in the most end
    }
    
    public int pop() {
        if (map.size() == 0) return -1;
        while (popIndex >= 0 && map.get(popIndex).size() == 0) popIndex--; //use while
        if (popIndex == -1) return -1;
        pushIndex = Math.min(pushIndex, popIndex);//push should be in the most front
        return map.get(popIndex).pop();
    }
    
    public int popAtStack(int index) {
        if (map.size() < index + 1 || map.get(index).size() == 0) return -1;
        pushIndex = Math.min(pushIndex, index);
        return map.get(index).pop();
    }
}