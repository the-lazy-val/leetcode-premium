class Solution {
    public String minWindow(String S, String T) {
        
        int tpointer = 0;
        
        int j=0;
        
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        
        String ans = null;
        
        while(j < s.length){
            
            if(s[j] == t[tpointer]){
                tpointer++;
            }
            
            if(tpointer == t.length){
                
                int reverse = j; //last position in S where last char of T was found
                
                while(tpointer > 0){ //now going back, reconstructing t from end, in S, if a smaller substring can be found (eg: dddog)
                    if(t[tpointer-1] == s[reverse]){ //because its 1 ahead at line 14
                        tpointer--;
                    }
                    reverse--;
                }
                
                if(ans==null || j-reverse < ans.length()){ //as reverse is 1 behind at line 27
                    ans = S.substring(reverse+1, j+1);
                }
                
                j=reverse+1;
            }
            
            j++;
        }
        
        return (ans==null) ? "" : ans;
    }
}
