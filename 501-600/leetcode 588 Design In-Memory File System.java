// leetcode 588 Design In-Memory File System

/*
time: O()
space: O()
*/

class FileSystem {
    class Node {
        String name;
        boolean isFile;
        StringBuilder content;
        Map<String, Node> children;
        
        public Node(String name) {
            this.content = new StringBuilder();
            this.name = name;
            this.isFile = isFile;
            this.children = new TreeMap<String, Node>();
        }
    }

	private Node root;
    public FileSystem() {
        root = new Node("/");
    }
    
    public List<String> ls(String path) {
        Node node = traverse(path);
        List<String> res = new ArrayList<String>();
        if (node.isFile) {
            res.add(node.name);
        } else {
            for (String child : node.children.keySet()) res.add(child);   
        }
        return res;
    }
    
    public void mkdir(String path) {
        traverse(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        Node node = traverse(filePath);
        node.isFile = true;
        node.content.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        Node node = traverse(filePath);
        return node.content.toString();
    }
    
    private Node traverse(String filePath) {
        String[] arr = filePath.split("/");
        Node cur = root;
        
        // start from index 1 as 0th element is ""
        for (int i = 1; i < arr.length; i++) {
            if (!cur.children.containsKey(arr[i])) {
                Node node = new Node(arr[i]);
                cur.children.put(arr[i], node);
            } 
            cur = cur.children.get(arr[i]);
        }
        return cur;
    }
}