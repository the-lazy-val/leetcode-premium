/**
My solution: 1 ms
beats 99 %
*/

class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put('(', ')');
        hm.put('{', '}');
        hm.put('[', ']');
        
        boolean flag = true;
       
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(hm.containsKey(c)){
                st.push(c);
            }else{
                if(st.size() > 0){
                    if(hm.get(st.peek()) == c){
                        st.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }else{
                    flag = false;
                    break;
                }
            }
        }
        
        if(st.size() > 0){
            flag = false;
        }
        return flag;
    }
}
