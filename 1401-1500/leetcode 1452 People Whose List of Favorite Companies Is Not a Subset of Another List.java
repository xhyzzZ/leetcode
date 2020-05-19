// leetcode 1452 People Whose List of Favorite Companies Is Not a Subset of Another List

/*
time: O(n^2)
space: O(n)
*/

class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i != j) {
                    Set<String> a = new HashSet<>(favoriteCompanies.get(i));
                    Set<String> b = new HashSet<>(favoriteCompanies.get(j));
                    if (b.containsAll(a)) flag = false;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        return list;
    }
}