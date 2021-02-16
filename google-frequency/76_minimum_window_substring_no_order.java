class Solution {
    
    /**
    The approach is:
    1. Use two pointers: start and end to represent a window.
    2. Move end to find a valid window.
    3. When a valid window is found, move start to find a smaller window.
    4. Expand window from right again and repeat until right reaches the end
    */
    
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> countTMap = new HashMap();
        
        for(char c : t.toCharArray()){
            countTMap.put(c, countTMap.getOrDefault(c, 0)+1);
        }
        
        int need = countTMap.size(); //number of unique chars in t
        int have = 0; //number of unique chars needed in window
        
        char[] str = s.toCharArray();
        
        int left=0;
        int right=0;
        
        HashMap<Character, Integer> countWindowMap = new HashMap();
        
        int resStart=-1;
        int resEnd=-1;
        int resLen=Integer.MAX_VALUE;
        
        while(right<str.length){
            char c = str[right];
            
            countWindowMap.put(c, countWindowMap.getOrDefault(c, 0)+1);
            
            if(countTMap.containsKey(c) && countTMap.get(c).intValue() == countWindowMap.get(c).intValue()){
                have+=1; //all occurences of char c is now in window, so we have 1 more char satisfying the conds
            }
            
            //now window has all needed chars
            while(have==need){
                
                if(right-left+1 < resLen){
                    resStart = left;
                    resEnd = right+1;
                    resLen = right-left+1;
                }
                
                //now we will shrink window from the left 
                // and check if this smaller window is still valid (i.e have==need)
                
                char leftChar = str[left];
                
                countWindowMap.put(leftChar, countWindowMap.get(leftChar).intValue()-1);
                
                
                /** This happens due to integer caching done by java. 
                The last test case causes the character counts to go above 128 and thus == doesn’t work as expected.
                You can use equals() for comparing Integer objects or use intValue() to unbox it into a primitive int.
                */
                
                if(countTMap.containsKey(leftChar) && 
                   countWindowMap.get(leftChar).intValue() < countTMap.get(leftChar).intValue()){
                    have-=1;
                }
                left+=1;
            }
            
            right+=1;
        }
        
        return (resStart==-1) ? "" : s.substring(resStart, resEnd);
    }
}
