/**
My solution: 11 ms
beats: 9 %
*/
class Solution {
    
    public String minimise(String s){
        StringBuilder res = new StringBuilder();
        
        int count = 1;
        char prev = s.charAt(0);
        
        for(char c : s.substring(1).toCharArray()){
            if(c == prev){
                count++;
            }else{
                
                if(count >= 10){
                    res.append(prev + Integer.toString(count));
                }else{
                    res.append(prev + "0" + Integer.toString(count));
                }
                
                prev = c;
                count = 1;
            }
        }
        
        if(count >= 10){
            res.append(prev + Integer.toString(count));
        }else{
            res.append(prev + "0" + Integer.toString(count));
        }
        
        return res.toString();
    }
    
    public boolean isStrechy(String minS, String minWord){
        for(int i=0; i<=minS.length()-3; i+=3){
            if(minS.charAt(i) != minWord.charAt(i)){
                return false;
            }
            
            int minSCount = Integer.parseInt(minS.substring(i+1, i+3));
            int minWordCount = Integer.parseInt(minWord.substring(i+1, i+3));
            
            if(minSCount != minWordCount){
                if(minSCount >= 3 && minWordCount < minSCount){
                    
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        if(S.length() == 0){
            return count;
        }
        
        String minS = minimise(S);
        
        for(String word: words){
            if(word.length() == 0 && S.length() == 0){
                count++;
            }else{
                String minWord = minimise(word);
                if(minS.length() == minWord.length()){
                    boolean check = isStrechy(minS, minWord);
                    if(check){
                        count++;
                    }
                }
            }
        }
        
        
        return count;
    }
}
