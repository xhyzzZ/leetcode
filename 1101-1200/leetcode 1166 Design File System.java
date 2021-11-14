// leetcode 1166 Remove Sub-Folders from the Filesystem

/*
time: create O(n) get O(n)
space: get O(1)
*/

class TrieNode {
    
    Map<String, TrieNode> children;
    int val = -1;
    
    public TrieNode() {
        this.children = new HashMap<>();
    }
}

class FileSystem {

    private TrieNode root;

    public FileSystem() {
        root = new TrieNode();
    }
    
    public boolean createPath(String path, int value) {
        String[] components = path.split("/");
        TrieNode runner = root;
        for (int i = 1; i < components.length; i++) {

            String currentComponent = components[i];
            if (runner.children.containsKey(currentComponent) == false) {
                
                // If it doesn't and it is the last node, add it to the Trie.
                if (i == components.length - 1) {
                    runner.children.put(currentComponent, new TrieNode());
                } else {
                    return false;
                }    
            }
            
            runner = runner.children.get(currentComponent);
        }
        
        // Value not equal to -1 means the path already exists in the trie. 
        if (runner.val != -1) {
            return false;
        }
        
        runner.val = value;
        return true;
    }
    
    public int get(String path) {
        String[] components = path.split("/");
        TrieNode runner = root;
        for (int i = 1; i < components.length; i++) {

            String currentComponent = components[i];
            // For each component, we check if it exists in the current node's dictionary.
            if (runner.children.containsKey(currentComponent) == false) {
                return -1;   
            }
            
            runner = runner.children.get(currentComponent);
        }
        return runner.val;
    }
}