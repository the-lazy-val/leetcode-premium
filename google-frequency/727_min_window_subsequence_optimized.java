//optimized sliding window

class Solution {
    
    public String minWindow(String S, String T) {
        
        String ans = "";
        
        int count=0; //count of chars of T encontered in this window in S
        
        for(int i=0; i<S.length(); i++){
            
            if(S.charAt(i) == T.charAt(count)){ //finding the end index
                count++;
            }
            
            if(count == T.length()){
                
                int temp = i; //last end position in S where last char of T was found
                
                while(count>0){
                    if(T.charAt(count-1) == S.charAt(temp)){
                        count--;
                    }
                    temp--; //we are traversing backward through temp to find the last index in S which matches first char in T
                }
                
                if(ans.equals("") || i-temp<ans.length()){
                    ans=S.substring(temp+1, i+1);
                }
                
                i = temp+1; //now the next start position... notice how this dodges the case of "dddddddog"
            }
            
        }
        
        
        return ans;
    }
}
