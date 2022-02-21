//leetcode 635 Design Log Storage System

/*
time: O()
space: O()
*/

class LogSystem {
	private TreeMap<String, List<Integer>> map;
    private Map<String, Integer> indexes;
    private String min = "2000:01:01:00:00:00", max = "2017:12:31:23:59:59";

    public LogSystem() {
        map = new TreeMap<>();
        indexes = new HashMap<>();
        indexes.put("Year", 4);
        indexes.put("Month", 7);
        indexes.put("Day", 10);
        indexes.put("Hour", 13);
        indexes.put("Minute", 16);
        indexes.put("Second", 19);
    }
    
    // The TreeMap is maintained internally as a Red-Black(balanced) tree. 
    // Thus, the putmethod takes O(log(n)) time
    public void put(int id, String timestamp) {
        if (!map.containsKey(timestamp)) {
            map.put(timestamp, new ArrayList<>());
        }
        
        map.get(timestamp).add(id);
    }
    
    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> result = new ArrayList<>();
        
        Map<String, List<Integer>> subMap = map.subMap(
            start.substring(0, indexes.get(granularity)) + min.substring(indexes.get(granularity)), true,
            end.substring(0, indexes.get(granularity)) + max.substring(indexes.get(granularity)), true
        );
        
        return subMap.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }
}
