/**
Better Approach

For each word, check if one mismatch occurs
*/

class MagicDictionary {
    class Trie{
        boolean isEnd;
        Map<Character, Trie> children;
        Trie(){
            children = new HashMap();
        }
    }
    Trie root;
    
    public MagicDictionary() {
        root = new Trie();
    }
    
    public void buildDict(String[] dict) {
        for(String s : dict){
            Trie curr = root;
            for(char c : s.toCharArray()){
                if(!curr.children.containsKey(c)){
                    curr.children.put(c, new Trie());
                }
                curr = curr.children.get(c);
            }
            curr.isEnd = true;
        }
    }
    
    public boolean search(String word) {
        return search(word, 0, root, false);
    }
    public boolean search(String word, int i, Trie node, boolean flag){
        if(i < word.length()){
            if(node.children.containsKey(word.charAt(i))){
                if(search(word, i+1, node.children.get(word.charAt(i)), flag)){ //this will only return true, if underlying call had atleast one mismatch
                    return true;
                }
            }
            if(!flag){ //this ensures, once a mismatch has occurred, (i.e. flag=true), it won't go inside again
                for(char c: node.children.keySet()){
                    if(c!= word.charAt(i) && search(word, i+1, node.children.get(c), true)) return true;
                }
            }
            return false; // return false, if no mismatch occurred
        }
        return flag && node.isEnd;
    }
}




/**
Slow solution, just change every character one-by-one & search that string exists in Trie
If even 1 true result, then break; & result in true
*/

class MagicDictionary {

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for(String w : dictionary){
            TrieNode temp = root;
            for(int i=0; i<w.length(); i++){
                char c = w.charAt(i);
                
                if(temp.children[c-'a']==null){
                    TrieNode newNode = new TrieNode();
                    if(i==w.length()-1) newNode.isEnd=true;
                    temp.children[c-'a'] = newNode;
                }
                
                temp = temp.children[c-'a'];
            }
            temp.isEnd=true;
        }
    }
    
    public boolean searchWord(TrieNode root, char[] str){
        for(char c : str){
            if(root.children[c-'a']==null) return false;
            root = root.children[c-'a'];
        }
        return root.isEnd;
    }
    
    public boolean search(String searchWord) {        
        char[] str = searchWord.toCharArray();
        for(int i=0; i<str.length; i++){
            for(char c='a'; c<='z'; c++){
                char org = str[i];
                
                if(org==c) continue; //because this won't modify the string
                
                str[i]=c;
                
                TrieNode temp = root;
                if(searchWord(temp, str)) return true;
                
                str[i]=org;
            }
        }
        
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
