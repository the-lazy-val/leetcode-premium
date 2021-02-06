class Solution {
    
    public boolean canTransform(String start, String end) {
        
        int i = 0;
        int j = 0;
        
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();
        
        while(i<s.length || j<e.length){
            // stop at char that is not 'X'
            while(i < s.length && s[i]=='X') i++; //skip 'X' chars
            while(j < e.length && e[j]=='X') j++; //skip 'X' chars
            
            // if either one has reached end, then check if both are at end
            if (i == s.length || j == e.length) { 
                return (i==s.length) && (j==e.length);
            }
            
            /**
            Lets say 
            start: XXXLXX
            end:   XLXXXX
            
            after replacing
            
            i=3 ___LXX
            j=1 _LXXXX
            
            since L can only be moved towards Left (XL -> LX), that means i needs to be greater than j
            
            similarly, since R can only be moved towards Right (RX -> XR), that means if current char is R, then i<j
            */
            
            // relative order for 'R' and 'L' in 2 strings should be the same
            if(s[i] != e[j]) return false;
            
            /**
            We must be able to use the given two operations (move 'L' to the left, move 'R' to the right) 
            to make them match in position (move start.charAt(i) from i to j)
            */
            
            // L can only move to left
            if(s[i] == 'L' && i<j) return false; // this condition checks for both valid postions, because i can be i==j OR i>j
            
            // R can only move to right
            if(s[i] == 'R' && i>j) return false; // this condition checks for both valid postions, because i can be i==j OR i<j
            
            
            //if nothing false, then that means s[i] == e[j]
            i++;
            j++;
        }
        
        return i==j; //reached end
    }
}
