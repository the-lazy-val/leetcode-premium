/**
1 ms
faster than 95%
*/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0 && popped.length != 0) return false;
        Stack<Integer> st = new Stack();
        int i=0;
        int j=0;
        
        while(j<popped.length && i<pushed.length){
            
            st.push(pushed[i]);
            i++;
            
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
        }
        
        return st.isEmpty();
    }
}
