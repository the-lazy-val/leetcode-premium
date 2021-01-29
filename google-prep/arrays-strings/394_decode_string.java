/**
My solution: 0ms
beats 100%
*/

class Solution {
    int i;
    public String dfs(int count, String s){
        
        if(i >= s.length()){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        
        int temp = 0;
        int num = 0;
        
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch == ']'){
                break;
            }
            else if(Character.isDigit(ch)){
                num = num*10 + (ch-'0');
                temp++;
                i++;
            }else{
                if(num==0){
                    sb.append(ch);
                    i++;
                }else{
                    i++;
                    sb.append(dfs(num, s));
                    i++;
                    temp=0;
                    num=0;
                }
            }
        }
        
        
        return sb.toString().repeat(count);
    }
    
    public String decodeString(String s) {
        i=0;
        return dfs(1, s);
    }
}
