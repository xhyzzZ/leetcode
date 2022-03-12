// leetcode 811 Subdomain Visit Count

/*
time: O(n)
space: O(n)
*/

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap();
        for (String domain : cpdomains) {
            int i = domain.indexOf(' ');
            int num = Integer.valueOf(domain.substring(0, i));
            String s = domain.substring(i + 1);
            for (i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '.') {
                    String d = s.substring(i + 1);
                    map.put(d, map.getOrDefault(d, 0) + num);
                }
            }
            map.put(s, map.getOrDefault(s, 0) + num);
        }

        List<String> res = new ArrayList();
        for (String key : map.keySet()) res.add(map.get(key) + " " + key);
        return res;
    }
}