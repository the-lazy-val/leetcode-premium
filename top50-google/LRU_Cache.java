class LRUCache {

    int cap;
    HashMap<Integer, Integer> hm;
    
    boolean first;
    
    Stack<Integer> latest;
    Stack<Integer> oldest;
    
    public LRUCache(int capacity) {
        cap = capacity;
        hm = new HashMap<>();
        first=true;
        
        latest = new Stack<>();
        oldest = new Stack<>();
    }
    
    public void setLatest(int key){
        
        if(latest.contains(key)){
                if(latest.peek() != key){
                    int c = 0;
                    while(latest.peek() !=key){
                        oldest.push(latest.pop());
                        c++;
                    }
                    int temp = latest.pop();
                    while(c>0){
                        latest.push(oldest.pop());
                        c--;
                    }
                    latest.push(temp);
                }
            }else{
                if(oldest.peek() == key){
                    latest.push(oldest.pop());
                }else{
                    int c=0;
                    while(oldest.peek()!=key){
                        latest.push(oldest.pop());
                        c++;
                    }
                    int temp = oldest.pop();
                    while(c>0){
                        oldest.push(latest.pop());
                        c--;
                    }
                    latest.push(temp);
                }
            }
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            setLatest(key);
            return hm.get(key);
        }else{
           return -1; 
        }
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            setLatest(key);
            hm.put(key, value);
        }else{
            if(cap > 0){
                System.out.println("has capacity, key: "+key+" , value: "+value);
                latest.push(key);
                hm.put(key, value);
                cap--;
            }else{
                if(!oldest.isEmpty()){
                    System.out.println("remove old top, key: "+key+" , value: "+value);
                    int oldK = oldest.pop();
                    hm.remove(oldK);
                    hm.put(key, value);
                    latest.push(key);
                }else{
                    System.out.println("swaps, key: "+key+" , value: "+value);
                    while(! latest.isEmpty()){
                        oldest.push(latest.pop());
                    }
                    int oldK = oldest.pop();
                    hm.remove(oldK);
                    hm.put(key, value);
                    latest.push(key);
                }
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
