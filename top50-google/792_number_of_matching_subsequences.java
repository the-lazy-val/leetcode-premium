/**
My solution

42 / 49 test cases passed
Time limit exceeds on case like:
S: wwwwwwwwwww.....q
words: [wq, wq, wq]
*/

class Solution {
    
    public int numMatchingSubseq(String S, String[] words) {
        int s = 0;
        while(s < S.length()){
            char curr = S.charAt(s);
            for(int i=0; i<words.length; i++){
                String w = words[i];
                if(w.length() > 0 && curr == w.charAt(0)){
                    words[i] = w.substring(1); //substring is expensive
                }
            }
            s++;
        }
        
        int output = 0;
        for(int i=0; i<words.length; i++){
            if(words[i].length() == 0) output++;
        }
        
        return output;
    }
}
