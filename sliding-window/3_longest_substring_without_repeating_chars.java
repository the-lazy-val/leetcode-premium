class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap(); //char -> index
        
        int maxLen = 0;
        
        char[] str = s.toCharArray();
        
        int i=0;
        int j=0;
        
        while(j<str.length){
            
            char c = str[j];
            if(hm.containsKey(c)){
                i = Math.max(i, hm.get(c)+1);
            }
            
            hm.put(c, j);
            
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        
        return maxLen;
    }
}
