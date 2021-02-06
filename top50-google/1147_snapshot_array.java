/**
My solution, using Array of HashMap

35 ms
beats 79%

*/

class SnapshotArray {

    int snap;
    HashMap<Integer, Integer>[] data;
    
    public SnapshotArray(int length) {
        data = new HashMap[length];
        snap=0;
    }
    
    public void set(int index, int val) {
        if(data[index]==null){
            HashMap<Integer, Integer> temp = new HashMap();
            temp.put(snap, val);
            data[index] = temp;
        }else{
            data[index].put(snap, val);
        }
    }
    
    public int snap() {
        snap+=1;
        return snap-1;
    }
    
    public int get(int index, int snap_id) {
        HashMap<Integer, Integer> temp = data[index];
        if(temp==null) return 0;
        else{
            int s = snap_id;
            while(s>=0){
                if(temp.containsKey(s)) return temp.get(s);
                s--;
            }
            
            return 0;
        }
    }
}
