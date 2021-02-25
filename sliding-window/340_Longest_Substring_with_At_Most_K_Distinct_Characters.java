class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap();
        
        int maxLen = 0;
        int i=0;
        int j=0;
        
        char[] str = s.toCharArray();
        
        while(j < str.length){
            
            char ch = str[j];
            
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
            
            if(hm.size() <= k){
                maxLen = Math.max(maxLen, j-i+1);
            }else{
                
                while(hm.size() > k){
                    
                    char rem = str[i];
                    int remCount = hm.get(rem);
                    
                    if(remCount == 1){
                        hm.remove(rem);
                    }else{
                        hm.put(rem, remCount-1);
                    }
                    i++;
                }
            }
            
            j++;
        }
        
        return maxLen;
    }
}
