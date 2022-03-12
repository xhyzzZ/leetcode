// leetcode 359 Logger Rate Limiter

/*
time: O(1)
space: O(m) where m is the maximum number of unique message that will be received in a 10 second period.
*/

class Logger {
    class TimeMsg {
	    int timestamp;
	    String msg;
	    public TimeMsg(int timestamp, String msg) {
	        this.timestamp = timestamp;
	        this.msg = msg;
	    }
	}
	/** Initialize your data structure here. */
	private static final int MAX_TIME_WINDOW = 10;
	Queue<TimeMsg> msgQueue;
	public Logger() {
	    msgQueue = new LinkedList<>();
	}
	/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	    If this method returns false, the message will not be printed.
	    The timestamp is in seconds granularity. */
	public boolean shouldPrintMessage(int timestamp, String message) {  
	    while (!msgQueue.isEmpty() && timestamp - msgQueue.peek().timestamp >= MAX_TIME_WINDOW) {
	        msgQueue.poll();
	    }
	    Iterator<TimeMsg> iter = msgQueue.iterator();
	    while (iter.hasNext()) {
	        TimeMsg tm = iter.next();
	        if (tm.msg.equals(message)) return false;
	    }
	    msgQueue.offer(new TimeMsg(timestamp, message));
	    return true;
	}
}

/*
time: O(1)
space: O(m) where m is the maximum number of unique message that will be received in a 10 second period.
*/

// timeNew record the start time of the mapNew.
// mapNew keeps the messages of [timeNew, timeNew +10);
// mapOld keeps messages at most 20 seconds before.

// As time elapses, we can clean up the mapOld, or even both of the maps.
class Logger {
    private Map<String, Integer> cacheOld;
    private Map<String, Integer> cacheNew;
    private int latest;

    /** Initialize your data structure here. */
    public Logger() {
        this.cacheOld = new HashMap<String, Integer>();
        this.cacheNew = new HashMap<String, Integer>();
        
        this.latest = 0;
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp >= latest + 20) {
            cacheOld.clear();
            cacheNew.clear();
            latest = timestamp;
        } else if (timestamp >= latest + 10) {
            cacheOld = new HashMap<>(cacheNew);
            cacheNew.clear();
            latest = timestamp;
        }
        
        if (cacheNew.containsKey(message)) return false;
        
        if (cacheOld.containsKey(message)) {
            int last = cacheOld.get(message);
            if (last + 10 > timestamp) return false;
        }
        
        cacheNew.put(message, timestamp);
        return true;
    }
}