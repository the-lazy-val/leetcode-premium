class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> charFreq = new HashMap(); //char -> freq
        
        int maxFreqOfAnyCharInWindow = 0;
        char mostFreqChar = '.';
        
        int i=0;
        int j=0;
        
        int longestSubstringLength = 0;
        
        char[] str = s.toCharArray();
        
        while(j < str.length){
            char ch = str[j];
            
            charFreq.put(ch, charFreq.getOrDefault(ch, 0)+1);
            
            if(charFreq.get(ch) > maxFreqOfAnyCharInWindow){
                maxFreqOfAnyCharInWindow = charFreq.get(ch);
                mostFreqChar = ch;
            }
            
            int windowSize = j-i+1;
            
            int requiredReplacements = windowSize - maxFreqOfAnyCharInWindow;
            
            if(requiredReplacements > k){//since we can replace only 'k' characters, shrink window from left
                char rem = str[i];
                charFreq.put(rem, charFreq.get(rem)-1);
                
                if(rem == mostFreqChar){//if removed char is mostFreqChar, then decrease it freq count
                    maxFreqOfAnyCharInWindow--;
                }
                i++;
            }
            
            longestSubstringLength = Math.max(longestSubstringLength, j-i+1);
            
            j++;//expand from right
        }
        
        return longestSubstringLength;
    }
}
