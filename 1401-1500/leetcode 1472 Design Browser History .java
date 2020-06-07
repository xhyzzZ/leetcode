// leetcode 1472 Design Browser History

/*
time: O()
space: O()
*/

class BrowserHistory {
    int curIndex = 0;
    List<String> h = new ArrayList<>();

    public BrowserHistory(String homepage) {
        h.add(homepage);
    }
    
    public void visit(String url) {
        while (curIndex != h.size() - 1) {
            h.remove(h.size() - 1);
        }
        h.add(url);
        curIndex++;
    }
    
    public String back(int steps) {
        curIndex = Math.max(curIndex - steps, 0);
        return h.get(curIndex);
    }
    
    public String forward(int steps) {
        curIndex = Math.min(curIndex + steps, h.size() - 1);
        return h.get(curIndex);
    }
}