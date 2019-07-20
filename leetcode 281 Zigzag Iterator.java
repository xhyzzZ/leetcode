//leetcode 281 Zigzag Iterator

/*
time: O()
space: O()
*/

public class ZigzagIterator {

    private int currInt;
    private boolean isv2;
    private List<Integer> v1;
    private List<Integer> v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.currInt = 0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        int out;
        if(!isv2 && currInt < v1.size()) {
            out = v1.get(currInt);
            if(currInt < v2.size())
                isv2 = true;
            else
                ++currInt;
        } else {
            out = v2.get(currInt++);
            if(currInt < v1.size())
                isv2 = false;
        }
        return out;
    }

    public boolean hasNext() {
        return currInt < v1.size() || currInt < v2.size();
    }
}