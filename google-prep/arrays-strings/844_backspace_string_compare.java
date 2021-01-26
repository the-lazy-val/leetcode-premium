/**
My solution: 3ms
beats 16%
*/
class Solution {
    
    public String minimise(String str){
        Stack<Character> st = new Stack<>();
        
        for(char c: str.toCharArray()){
            if(c=='#'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(c);
            }
        }
        
        return st.toString();
    }
    
    public boolean backspaceCompare(String S, String T) {
        return minimise(S).equals(minimise(T));
    }
}


/**
My improved solution. not using stack, but string builder
traversing reverse
maintain count of '#' and not append chars if this count>0

runtime: 1ms
beats 68%
*/

class Solution {
    
    public String minimise(String str){
        StringBuilder sb = new StringBuilder();
        int len = str.length()-1;
        int count = 0;
        while(len >= 0){
            char ch = str.charAt(len);
            if(ch == '#'){
                count++;
            }else if(count > 0){
                count--;
            }else{
                sb.append(ch);
            }
            len--;
        }
        
        return sb.toString();
    }
    
    
    public boolean backspaceCompare(String S, String T) {
        return minimise(S).equals(minimise(T));
    }
}
