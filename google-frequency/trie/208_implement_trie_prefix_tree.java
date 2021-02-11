class Trie {
    
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode(){
            isEnd=false;
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        for(int i=0; i<word.length(); i++){
            
            char c = word.charAt(i);
            
            if(temp.children[c-'a']==null){
                temp.children[c-'a'] = new TrieNode();
            }
            temp = temp.children[c-'a'];
        }
        temp.isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp=root;
        for(char c : word.toCharArray()){
            if(temp.children[c-'a']==null) return false;
            temp = temp.children[c-'a'];
        }
        
        return temp.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp=root;
        for(char c : prefix.toCharArray()){
            if(temp.children[c-'a']==null) return false;
            temp = temp.children[c-'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
