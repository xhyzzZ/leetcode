// leetcode 1352 Product of the Last K Numbers

/*
time: O()
space: O()
*/

class ProductOfNumbers {
    List<Integer> prefix;
    int p;
    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        p = 1;
    }

    public void add(int num) {
        if (num == 0) {
            prefix = new ArrayList<>();
            p = 1;
            return;
        }
        p *= num;
        prefix.add(p);
    }
    
    public int getProduct(int k) {
        if (prefix.size() < k) return 0;
        int ans = prefix.get(prefix.size() - 1);
        if (prefix.size() == k) return ans;
        return (ans / prefix.get(prefix.size() - 1 - k));
    }
}