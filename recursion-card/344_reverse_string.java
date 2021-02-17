class Solution {
    
    public void helper(int left, int right, char[] s){
        if(left>=right) return;
        
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        
        helper(left+1, right-1, s);
    }
    
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        
        helper(left, right,  s);
    }
}
