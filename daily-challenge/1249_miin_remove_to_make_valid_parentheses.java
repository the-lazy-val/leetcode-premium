class Solution {
    
    class Paren{
        char symbol;
        int index;
        
        public Paren(char c, int i){
            symbol=c;
            index=i;
        }
    }
    
    public String minRemoveToMakeValid(String s) {
        
        Stack<Paren> st = new Stack();
        
        StringBuilder sb = new StringBuilder();
        
        char[] str = s.toCharArray();
        
        for(int i=0; i<str.length; i++){
            
            char ch = str[i];
            
            if(ch == '('){
                st.push(new Paren('(', i));
            }else if(ch == ')'){
                if(!st.isEmpty()){
                    Paren top = st.peek();
                    if(top.symbol=='('){
                        st.pop();
                    }else{
                        st.push(new Paren(')', i));
                    }
                }else{
                    st.push(new Paren(')', i));
                }
            }
            
            sb.append(ch);
        }
        
        while(!st.isEmpty()){
            Paren pop = st.pop();
            sb.deleteCharAt(pop.index);
        }
        
        return sb.toString();
    }
}
