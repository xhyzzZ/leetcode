// leetcode 1415 The k-th Lexicographical String of All Happy Strings of Length n

/*
time: O(3^n)
space: O()
*/

class Solution {
    public String getHappyString(int n, int k) {
        char[] arr = {'a', 'b', 'c'};
        String cur = "";
        List<String> list = new ArrayList<>();
        dfs(arr, n, cur, list);
        if (list.size() >= k) cur = list.get(k - 1);
        return cur;
    }
    
    private void dfs(char[] arr, int n, String cur, List<String> list){
        if (n == 0) {
            list.add(cur);
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
           if (cur == "" || cur.charAt(cur.length() - 1) != arr[i]) {
                String pre = cur + arr[i];
                dfs(arr, n - 1, pre, list);
            }
        }
    }
}
