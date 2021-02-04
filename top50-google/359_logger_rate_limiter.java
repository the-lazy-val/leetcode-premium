class Logger {

    HashMap<String, Integer> hm;
    
    /** Initialize your data structure here. */
    public Logger() {
        hm = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(hm.containsKey(message) && timestamp < hm.get(message)){
            return false;
        }else{
            hm.put(message, timestamp+10);
            return true;
        }
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
