class Solution {
    public int balancedStringSplit(String s) {
        char curr = s.charAt(0);
        
        int count = 0;
        
        int output = 0;
        
        for(char c : s.toCharArray()){
            if(count == 0){
                curr = c;
                count++;
            }else if(c == curr){
                count++;
            }else{
                count--;
                if(count == 0) output++;
            }
        }
        
        return output;
    }
}
