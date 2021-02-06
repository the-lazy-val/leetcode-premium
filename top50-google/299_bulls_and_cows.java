/**
My solution: 7 ms
O(3N)
*/

class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        
        HashMap<Character, Integer> hm = new HashMap();
        HashMap<Character, Integer> hm2 = new HashMap();
        
        for(int i=0; i<secret.length(); i++){
            char c = secret.charAt(i);
            hm.putIfAbsent(c, 0);
            hm.put(c, hm.get(c)+1);
            
            c = guess.charAt(i);
            hm2.putIfAbsent(c, 0);
            hm2.put(c, hm2.get(c)+1);
        }
        
        for(int i=0; i<secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s==g){
                bulls++;
                int currCount = hm.get(s);
                if(currCount==1) hm.remove(s); else hm.put(s, currCount-1);
                
                currCount = hm2.get(g);
                if(currCount==1) hm2.remove(g); else hm2.put(g, currCount-1);
            }  
        }
        
        for(Map.Entry<Character, Integer> e : hm2.entrySet()){
            if(hm.containsKey(e.getKey())){
                cows+= Math.min(hm.get(e.getKey()), e.getValue());
            }
        }
        
        return bulls+"A"+cows+"B";
    }
}
