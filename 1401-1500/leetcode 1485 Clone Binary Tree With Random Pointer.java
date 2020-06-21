// leetcode 1485 Clone Binary Tree With Random Pointer

/*
time: O(n)
space: O(h + n)
*/

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> map =  new HashMap<>();
        NodeCopy newRoot = helper(root, map);
        random(root, newRoot, map);
        return newRoot;
    }
    
    private NodeCopy helper(Node root, Map<Node, NodeCopy> map) {
        if (root == null) return null;
        NodeCopy newRoot = new NodeCopy(root.val);
        map.put(root, newRoot);  
        newRoot.left = helper(root.left, map);
        newRoot.right = helper(root.right, map);
        return newRoot;
    }
    
    private void random(Node root, NodeCopy newRoot, Map<Node, NodeCopy> map) {
        if (root == null) return;
        newRoot.random = map.get(root.random);
        random(root.left, newRoot.left, map);
        random(root.right, newRoot.right, map);
    }
}