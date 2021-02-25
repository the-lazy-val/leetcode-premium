class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length() || s.length()==0 || t.length()==0) return "";
        
        HashMap<Character, Integer> tmap = new HashMap();
        
        for(char c : t.toCharArray()){
            tmap.put(c, tmap.getOrDefault(c, 0)+1);
        }
        
        int unique = tmap.size();
        
        int i=0;
        int j=0;
        
        char[] str = s.toCharArray();
        
        String output = null;
        
        while(j < str.length){
            
            char ch = str[j];
            
            if(tmap.containsKey(ch)){
                int chCount = tmap.get(ch);
                if(chCount==1){
                    unique--;
                }
                tmap.put(ch, chCount-1); //calculations
            }
            
            while(unique==0){ //window hit
                
                if(output==null || (j-i+1) < output.length()){
                    output = s.substring(i, j+1);
                }
                
                char rem = str[i];
                
                if(tmap.containsKey(rem)){
                    
                    int remCount = tmap.get(rem);
                    
                    if(remCount==0) unique++;
                    
                    tmap.put(rem, tmap.get(rem)+1);
                }
                
                i++; //contract window from left
            }
            
            j++; //keep expanding on right
        }
        
        return (output==null) ? "" : output;
    }
}
