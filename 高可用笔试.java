//高可用笔试
//问题一：字符串模式匹配
public class Problem1 {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat fish";

        System.out.println(isMatched(pattern, str));
    }
    public static boolean isMatched(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(key) && !map.get(key).equals(word)) return false;
            if (!map.containsKey(key) && map.containsValue(word)) return false;
            map.put(key, word);
        }
        return true;
    }
}


//问题二：移除子串
public class Problem2 {
    public static void main(String[] args) {
        String str = "ccdaabcdbb";
        List<String> words = new ArrayList<String>(Arrays.asList("ab","cd"));

        System.out.println(minLen(str, words));
    }

    public static int minLen(String str, List<String> words) {
        Queue<String> queue = new LinkedList<>();
        Set<String> hash = new HashSet<>();

        int len = str.length();
        queue.offer(str);
        hash.add(str);

        while (!queue.isEmpty()) {
            String string = queue.poll();
            for (String word : words) {
                int found = string.indexOf(word);
                while (found != -1) {
                    String newString = string.substring(0, found) + string.substring(found + word.length(), string.length());
                    if (!hash.contains(newString)) {
                        if (newString.length() < len) {
                            len = newString.length();
                        }
                        queue.offer(newString);
                        hash.add(newString);
                    }
                    found = string.indexOf(word, found + 1);
                }
            }
        }
        return len;
    }
}

