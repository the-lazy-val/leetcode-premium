//Similar to find all anagrams - sliding window
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int K = s1.length();
        HashMap<Character, Integer> map = new HashMap();
        
        for(char c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int unique = map.size();
        
        int i=0;
        int j=0;
        
        char[] str = s2.toCharArray();
        
        while(j < str.length){
            
            char ch = str[j];
            
            if(map.containsKey(ch)){
                int chCount = map.get(ch);
                if(chCount==1) unique--;
                map.put(ch, chCount-1);
            }
            
            if(j-i+1 == K){
                if(unique==0) return true;
                
                char rem = str[i];
                if(map.containsKey(rem)){
                    int remCount = map.get(rem);
                    if(remCount==0) unique++;
                    map.put(rem, remCount+1);
                }
                i++;
            }
            
            j++;
        }
        
        return false;
    }
}
