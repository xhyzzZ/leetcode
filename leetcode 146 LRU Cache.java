//leetcode 146 LRU Cache


/*
time: O()
space: O()
hashmap + double linkedlist
*/


public class LRUCache {


	private class Node {
		int key;
		int value;
		Node next;
		Node pre;
		Node(int k, int v) {
			this.key = k;
			this.value = v;
		}
		Node(){
			this(0, 0);
		}
	}
	private int capacity, count;
	private Map<Integer, Node> map;
	private Node head, tail;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(null == n) {
        	return -1;
        }
        update(n);
        return n.value;
    }
    
    public void set(int key, int value) {
        Node n = map.get(key);
        if(null == n) {
        	n = new Node(key, value);
        	map.put(key, n);
        	add(n);
        	++count;
        } else {
        	n.value = value;
        	update(n);
        }
        if(count > capacity) {
        	Node toDel = tail.pre;
        	remove(toDel);
        	map.remove(toDel.key);
        	--count;
        }
    }

    private void update(Node node) {
    	remove(node);
    	add(node);
    }
    private void add(Node node) {
    	Node after = head.next;
    	head.next = node;
    	node.pre = head;
    	node.next = after;
    	after.pre = node;
    }

    private void remove(Node node) {
    	Node before = node.pre, after = node.next;
    	before.next = after;
    	after.pre = before;
    }
}