// We build trie using the wordDict and then search with the string, breaking at wherever trie ending has a word
//https://leetcode.com/problems/word-break/discuss/43879/Beat-90-JavaC%2B%2B-Trie-DP-Solution-36-lines-7ms3msJava-Set-DP-solution-31-lines-7ms)

class Solution {
    
    class TrieNode{
        boolean isWord;
        TrieNode[] children;
    
        public TrieNode(){
            isWord=false;
            children = new TrieNode[26];
        }
    }
    
    public void addToTrie(TrieNode root, String w){
        TrieNode curr = root;
        for(char ch : w.toCharArray()){
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isWord=true;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        
        for(String w : wordDict){
            addToTrie(root, w);
        }
        
        boolean[] dp = new boolean[s.length()+1]; //length + 1
        
        dp[0] = true;
        
        for(int i=0; i<s.length(); i++){
            if(!dp[i]){
                continue; //let's say "s" is "apple"  & wordlist has "app", then after trie traversal, dp[3] will be updated to true (because of length+1 above), and then we will continue searching after that... middle ones may be false
            }else{
                int j=i;
                
                TrieNode curr=root;
                
                //traversing the trie
                while(j<s.length() && curr.children[s.charAt(j)-'a'] !=null){
                    curr = curr.children[s.charAt(j)-'a'];
                    j++;
                    if(curr.isWord)
                        dp[j]=true;
                }
            }
        }
        
        
        return dp[s.length()];
    }
}
