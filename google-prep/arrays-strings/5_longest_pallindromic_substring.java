/**

DP approach

https://www.youtube.com/watch?v=UflHuQj6MVA
*/

class Solution {
    
    boolean[][] dp;
    
    public String longestPalindrome(String s) {
        int len = s.length();
        dp = new boolean[len][len];
        
        for(int i=0; i<len; i++){
            dp[i][i] = true;
        }
        
        int start=0;
        int end=0;
        
        for(int i=1; i<=len-1; i++){
            if(s.charAt(i-1) == s.charAt(i)){
                dp[i-1][i] = true;
                start=i-1;
                end=i;
            }
        }
        
        int inc = 2;
        while(inc < len){
            for(int i=0; i<len-inc; i++){
                if((s.charAt(i) == s.charAt(i+inc)) && dp[i+1][i+inc-1]){
                    dp[i][i+inc] = true;
                    start = i;
                    end = i+inc;
                }
            }
            inc++;
        }
        
        return s.substring(start, end+1);
    }
}


/**
Better performance

https://leetcode.com/problems/longest-palindromic-substring/discuss/2928/Very-simple-clean-java-solution

Approach is for a string: abbaccbbcc

start from 0 -> n
and expand the string in both directions if i-1 == i+1 
- for odd: start with single char s.charAt(i)
- for even: start with 2 length string: s.charAt(i) + s.charAt(i+1)

*/

public class Solution {
private int lo, maxLen;

public String longestPalindrome(String s) {
	int len = s.length();
	if (len < 2)
		return s;
	
    for (int i = 0; i < len-1; i++) {
     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
     	extendPalindrome(s, i, i+1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
}

private void extendPalindrome(String s, int j, int k) {
	while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
		j--;
		k++;
	}
	if (maxLen < k - j - 1) {
		lo = j + 1;
		maxLen = k - j - 1;
	}
}}

/**
Another variation of above solution
*/
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i), s2 = extend(s, i, i + 1);
            if (s1.length() > max.length()) max = s1;
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }
    
    private String extend(String s, int i, int j) {
        for (; 0 <= i && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i + 1, j);
    }
