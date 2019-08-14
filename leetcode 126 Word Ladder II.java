//leetcode 126 Word Ladder II

/*
time: O()
space: O()
*/

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	    
	    List<List<String>> res = new ArrayList<>();
	    Set<String> dict = new HashSet<>(wordList);
	    if (!dict.contains(endWord)) return res;
	    Set<String> begin = new HashSet<>();
	    Set<String> end = new HashSet<>();
	    begin.add(beginWord);
	    end.add(endWord);
	    Map<String, List<String>> map = new HashMap<String, List<String>>();
	    
	    // BFS 在这里只是起到一个更新 hashmap 的作用，hashmap 存着所有有效的 adjacency list
	    bfs(dict, begin, end, map);
	    List<String> temp = new ArrayList<>(Arrays.asList(beginWord));
	    // DFS 负责返回并写入所有 paths
	    dfs(res, temp, beginWord, endWord, map);
	    
	    return res;
	}
	// 因为我们使用bi-dfs，所以我们需要跟踪bfs的方向，并记录在hashmap中
	private void bfs(Set<String> dict, Set<String> begin, Set<String> end, Map<String, List<String>> map) {
	    
	    boolean reversed = false;
	    boolean terminate = false;
	    while (begin.size() > 0) {
	    	// 避免搜索重复元素，免得搜索路径上出现环
	        dict.removeAll(begin);
	        dict.removeAll(end);
	        if (begin.size() > end.size()) {
	            reversed = !reversed;
	            Set<String> temp = new HashSet<>(begin);
	            begin = end;
	            end = temp;
	        }
	        Set<String> set = new HashSet<>();
	        for (String s : begin) {
	            for (int i = 0; i < s.length(); i++) {
	                char[] ch = s.toCharArray();
	                for (char c = 'a'; c <= 'z'; c++) {
	                    if (ch[i] == c) continue;
	                    ch[i] = c;
	                    String word = new String(ch);
	                    if (end.contains(word)) {
	                        if (!reversed) {
	                            List<String> list = map.containsKey(s) ? map.get(s) : new ArrayList<>();
	                            list.add(word);
	                            map.put(s, list);
	                        } else {
	                            List<String> list = map.containsKey(word) ? map.get(word) : new ArrayList<>();
	                            list.add(s);
	                            map.put(word, list);
	                        }
	                        terminate = true;
	                    }
	                    if (dict.contains(word)) {
	                        if (!reversed) {
	                            List<String> list = map.containsKey(s) ? map.get(s) : new ArrayList<>();
	                            list.add(word);
	                            map.put(s, list);
	                        } else {
	                            List<String> list = map.containsKey(word) ? map.get(word) : new ArrayList<>();
	                            list.add(s);
	                            map.put(word, list);
	                        }
	                        set.add(word);
	                    }
	                }
	            }
	        }
	        begin = set;
	        if (terminate) return;
	    }
	    return;
	}

	private void dfs(List<List<String>> res, List<String> temp, String start, String end, Map<String, List<String>> map) {
	    
	    if (start.equals(end)) {
	        res.add(new ArrayList<>(temp));
	        return;
	    }
	    if (!map.containsKey(start)) return;   
	    for (String word : map.get(start)) {
	        temp.add(word);
	        dfs(res, temp, word, end, map);
	        temp.remove(temp.size() - 1);
	    }
	}
}