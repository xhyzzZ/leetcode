// leetcode 1357 Apply Discount Every n Orders

/*
time: O()
space: O()
*/ 

class Cashier {
    int count = 0;
    Map<Integer, Integer> map;
    int dis;
    int limit;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        limit = n;
        map = new HashMap<>();
        dis = discount;
        for (int i = 0; i < prices.length; i++) {
            map.put(products[i], prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        count++;
        double cost = 0;
        for (int i = 0; i < amount.length; i++) {
            cost += map.get(product[i]) * amount[i];
        }
        
        if (count == limit) {
            count = 0;
            return cost -= (dis * cost) / 100;
        } else {
            return cost;
        }
    }
}