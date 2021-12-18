// leetcode 2034 Stock Price Fluctuation

/*
time: O(logn)
space: O(n)
*/

class StockPrice {

    Map<Integer, Integer> prices = new HashMap<>();
    TreeMap<Integer, Integer> ordered = new TreeMap<>();
    int latestTime = -1;

    public void update(int timestamp, int price) {
        if (prices.containsKey(timestamp)) {
            int prevPrice = prices.get(timestamp);
            ordered.put(prevPrice, ordered.get(prevPrice) - 1);
            if (ordered.get(prevPrice) == 0)
                ordered.remove(prevPrice);
        }
        prices.put(timestamp, price);
        ordered.put(price, ordered.getOrDefault(price, 0) + 1);
        latestTime = Math.max(latestTime, timestamp);
    }
    
    public int current() {
        return prices.get(latestTime);
    }
    
    public int maximum() {
        return ordered.lastKey();
    }
    
    public int minimum() {
        return ordered.firstKey();
    }
}
