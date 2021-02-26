class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int i=0;
        int j=0;
        
        HashMap<Character, Integer> hm = new HashMap(); //char -> index
        HashMap<Character, Integer> leftRep = new HashMap(); //char -> left replacements
        
        char[] str = s.toCharArray();
        
        int[] dp = new int[str.length];
        
        while(j < str.length){
            char c = str[j];
            
            if(hm.containsKey(c)){
                int prev = hm.get(c);
                
                int distanceFromPrev = j-prev-1;
                
                if(distanceFromPrev == 0){
                    dp[j] = dp[prev] + 1;
                }else if(distanceFromPrev <= k){
                    dp[j] = distanceFromPrev + 2;
                    
                    int leftK = k-distanceFromPrev;
                    dp[j] += Math.min(str.length - dp[j], leftK);
                }else{
                    dp[j] = 1 + Math.min(k, j);
                }
            }else{
                dp[j] = 1 + Math.min(k, j);
            }
            
            max = Math.max(max, dp[j]);
            
            hm.put(c, j);
            j++;
        }
        
        return max;
    }
}
