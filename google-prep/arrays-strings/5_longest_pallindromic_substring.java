/**

DP approach

https://www.youtube.com/watch?v=UflHuQj6MVA
*/

class Solution {
    
    boolean[][] dp;
    
    public String longestPalindrome(String s) {
        int len = s.length();
        dp = new boolean[len][len];
        
        for(int i=0; i<len; i++){
            dp[i][i] = true;
        }
        
        int start=0;
        int end=0;
        
        for(int i=1; i<=len-1; i++){
            if(s.charAt(i-1) == s.charAt(i)){
                dp[i-1][i] = true;
                start=i-1;
                end=i;
            }
        }
        
        int inc = 2;
        while(inc < len){
            for(int i=0; i<len-inc; i++){
                if((s.charAt(i) == s.charAt(i+inc)) && dp[i+1][i+inc-1]){
                    dp[i][i+inc] = true;
                    start = i;
                    end = i+inc;
                }
            }
            inc++;
        }
        
        return s.substring(start, end+1);
    }
}
