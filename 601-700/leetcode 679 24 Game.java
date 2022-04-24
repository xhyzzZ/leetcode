// leetcode 679 24 Game

/*
Time complexity is O(9216) reduced to O(1)
There are 4 numbers to choose from: 4
After choosing the 1st number, there are 3 numbers to choose from: 3
after picking a pair of numbers, you have 4 operations to choose from: 4
Then you have 3 numbers to choose from: 3
Then you have 2 numbers to choose from: 2
after picking a pair of numbers, you have 4 operations to choose from: 4
Then you have 2 numbers to choose from: 2
Then you have 1 number1 to choose from: 1
after picking a pair of numbers, you have 4 operations to choose from: 4
4x3x4x3x2x4x2x1x4 = O(9216) = O(1)
space: O()
*/

class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for(int num : nums) {
            list.add((double) num);
        }
        return dfs(list);
    }

    // 每次dfs都是选取两张牌
    private boolean dfs(List<Double> list) {
        if (list.size() == 1) {
            // 如果此时list只剩下了一张牌
            if (Math.abs(list.get(0) - 24.0) < 0.001) {
                return true;
            }
            return false;
        }
        
        // 选取两张牌
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                // 对于每下一个可能的产生的组合
                for (double c : compute(list.get(i), list.get(j))) {
                    List<Double> nextRound = new ArrayList<>();
                    // 将他们加入到下一个list循环中去
                    nextRound.add(c);
                    for (int k = 0; k < list.size(); k++) {
                        if (k == j || k == i) continue;
                        nextRound.add(list.get(k));
                    }
                    if (dfs(nextRound)) return true;
                }
            }
        }
        return false;
    }
    // 计算下一个可能产生的组合
    private List<Double> compute(double a, double b) {
        List<Double> res = Arrays.asList(a + b, a - b, b - a, a * b, a / b, b / a);
        return res;
    }
}