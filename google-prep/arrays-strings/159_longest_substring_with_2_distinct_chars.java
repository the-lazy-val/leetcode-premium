/**
My solution: 9 ms
beats 39 %
*/
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 3){
            return s.length();
        }
        
        HashMap<Character, Integer> hm = new HashMap<>();
        char prev = s.charAt(0);
        hm.put(prev, 1);
        
        int temp = 1;
        int max = 1;
        
        for(char c : s.substring(1).toCharArray()){
            if(hm.containsKey(c)){
                temp++;
                if(c == prev){
                    hm.put(c, hm.get(c)+1);
                }else{
                    hm.put(c, 1);
                }
            }else{
                if(hm.size() == 1){
                    temp++;
                    hm.put(c, 1);
                }else{
                    int previousCount = hm.get(prev);
                    temp = previousCount + 1;

                    hm.clear();
                    hm.put(prev, previousCount);
                    
                    hm.put(c, 1);
                }
            }
            
            prev = c;
            max = Math.max(temp, max);
        }
        
        return max;
    }
}
