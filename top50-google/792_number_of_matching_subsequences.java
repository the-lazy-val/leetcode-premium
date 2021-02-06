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



/**
Better solution

beats 95%

https://leetcode.com/problems/number-of-matching-subsequences/discuss/117598/Java-solution-using-HashMap-and-Queue/307409

*/

class Item{
    String word;
    int index;
    int length;
    
    public Item(String w, int i, int l){
        word=w;
        index=i;
        length=l;
    }
}

class Solution {
    
    public int numMatchingSubseq(String S, String[] words) {
        Queue<Item>[] dict = new Queue[26];
        
        for(int i=0; i<26; i++){
            dict[i] = new LinkedList();
        }
        
        for(String w : words){
            dict[w.charAt(0)-'a'].add(new Item(w, 0, w.length()));
        }
        
        int output=0;
        
        for(char c : S.toCharArray()){
            
            Queue<Item> q = dict[c-'a'];
            dict[c-'a'] = new LinkedList();
            
            while(q.size()>0){
                Item item = q.remove();
                if(item.index+1 == item.length){
                    output++;
                }else{
                    item.index+=1;
                    dict[item.word.charAt(item.index)-'a'].add(item);
                }
            }
        }
        
        return output;
    }
}
