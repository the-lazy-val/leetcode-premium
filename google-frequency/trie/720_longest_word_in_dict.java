/**
My solution: 
Sort array and then Trie
keep count of incremental chars while filling words
*/

class Solution {
    
    class TrieNode{
        boolean isWord;
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    public Pair<Integer, String> addWord(TrieNode root, String word){
        int count=1;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(root.children[c-'a']==null){
                TrieNode temp = new TrieNode();
                if(i==word.length()-1) temp.isWord=true;
                root.children[c-'a'] = temp;
            }else if(root.children[c-'a'].isWord){
                count++;
            }
            root=root.children[c-'a'];
        }
        
        // System.out.println("Word: "+word+" , count:"+count);
        if(count!=word.length()) count=0;
        return new Pair(count, word);
    }
    
    public String longestWord(String[] words) {
        int max = 0;
        String maxString = "";

        Arrays.sort(words);
        
        TrieNode root = new TrieNode();
        
        for(String w : words){
            TrieNode temp = root;
            Pair<Integer, String> pair = addWord(temp, w);
            
            if(pair.getKey() == max){
                if(maxString.compareTo(pair.getValue()) > 0){
                    maxString=pair.getValue();
                }
            }
            
            if(pair.getKey() > max){
                max=pair.getKey();
                maxString=pair.getValue();
            }
        }
        
        return maxString;
    }
}
