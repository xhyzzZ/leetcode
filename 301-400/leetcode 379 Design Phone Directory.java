//leetcode 379 Design Phone Directory

/*
time: O()
space: O()
*/

class PhoneDirectory {
	private int max;
	private Set<Integer> used;
	private LinkedList<Integer> free;

	/** Initialize your data structure here
	    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public PhoneDirectory(int maxNumbers) {
	    max = maxNumbers;
	    used = new HashSet<>();
	    free = new LinkedList<>();
	}

	/** Provide a number which is not assigned to anyone.
	    @return - Return an available number. Return -1 if none is available. */
	public int get() {
	    if(used.size() == max) return -1;
	    Integer ret = free.isEmpty() ? used.size() : free.remove();
	    used.add(ret);
	    return ret;
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
	    return !used.contains(number);
	}

	/** Recycle or release a number. */
	public void release(int number) {
	    if(used.remove(number))
	        free.add(number);
	}
}