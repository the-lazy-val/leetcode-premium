/**
Just alphabaet
*/

class Solution {
    
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        
        for(int c : count){
            if(c != 0) return false;
        }
        
        return true;
    }
}

/**
For ASCII as well, use HashMap
*/

class Solution {
    
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c : s.toCharArray()){
            hm.putIfAbsent(c, 0);
            hm.put(c, hm.get(c)+1);
        }
        
        for(char c : t.toCharArray()){
            if(!hm.containsKey(c)){
                return false;
            }else{
                int val = hm.get(c)-1;
                if(val==0){
                    hm.remove(c);
                }else{
                    hm.put(c, val);
                }
            }
        }
        
        if(hm.isEmpty()) return true; else return false;
    }
}
