/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    
    HashSet<String> hs = new HashSet();
    
    public void modifySet(String guessWord, int guessMatches){
        ArrayList<String> remove = new ArrayList();
        for(String w : hs){
            int count=0;
            for(int i=0; i<6; i++){
                if(w.charAt(i) == guessWord.charAt(i)) count++;
            }
            
            if(count < guessMatches) remove.add(w);
        }
        
        remove.add(guessWord);
        
        hs.removeAll(remove);
    }
    
    public void findSecretWord(String[] wordlist, Master master) {
        
        
        hs.addAll(Arrays.asList(wordlist));
        
        int count =0;
        
        Random rand = new Random();
        
        int globalMatchCount=0;
        
        while(count<10){
            
            Iterator<String> iter = hs.iterator();
            
            int pick = rand.nextInt(hs.size());
            
            for(int i=0; i<pick-1; i++){
                iter.next();
            }
            
            String guessWord = iter.next();
            
            int guess = master.guess(guessWord);
            
            if(guess==6) break;
            
            // System.out.println(hs.size());
            
            if(guess >= globalMatchCount){
                modifySet(guessWord, guess);
                globalMatchCount=guess;
            }
            
            
            // System.out.println(hs.size());
            
            count++;
        }
    }
}
