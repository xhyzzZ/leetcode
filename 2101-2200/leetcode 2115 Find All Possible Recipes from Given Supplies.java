// leetcode 2115 Find All Possible Recipes from Given Supplies

/*
time: O(v + e)
space: O(v + e)
*/

class Solution {
    // Assumption: ingredients do not contain any recipe.

    // For each recipe, count its dependent ingredients as in degree; Store (ingredient, recipes that dependent on it) as HashMap;
    // Use the supplies as the starting points of topological sort;
    // Use topogical sort to decrease the in degree of recipes, whenever the in-degree reaches 0, add it to return list.
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Construct directed graph and count in-degrees.
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, s -> new HashSet<>()).add(recipes[i]);
            }
            inDegree.put(recipes[i], ingredients.get(i).size());
        }

        // Toplogical Sort.
        List<String> ans = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        for (String supply : supplies) queue.offer(supply);

        while (!queue.isEmpty()) {
            String ing = queue.poll();
            if (graph.containsKey(ing)) {
                for (String rcp : graph.remove(ing)) {
                    if (inDegree.merge(rcp, -1, Integer::sum) == 0) {
                        queue.offer(rcp);
                        ans.add(rcp);
                    }
                }
            }
        }
        return ans;
    }
}