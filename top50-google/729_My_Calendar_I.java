/**
My solution using TreeMap

20 ms
beats 87%
*/

class MyCalendar {

    TreeMap<Integer, Integer> tmap;
    public MyCalendar() {
        tmap = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        if(tmap.isEmpty()){
            tmap.put(start, end);
            return true;
        }else{
            Map.Entry<Integer, Integer> startFloor = tmap.floorEntry(start);
            if(startFloor!=null){    
                boolean cond = 
                    (start>=startFloor.getValue() && end > startFloor.getValue()) || 
                    (start<startFloor.getKey() && end<=startFloor.getKey());
                
                if(!cond) return false;
            }
            
            Map.Entry<Integer, Integer> startCeil = tmap.ceilingEntry(start);
            if(startCeil!=null){
                boolean cond =
                    (start<startCeil.getKey() && end<=startCeil.getKey()) ||
                    (start>=startCeil.getValue() && end>startCeil.getValue());
                    
                if(!cond) return false;
            }
                
            tmap.put(start, end);
            return true;
        }
    }
}
