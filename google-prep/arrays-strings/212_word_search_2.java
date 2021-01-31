/**
https://www.youtube.com/watch?v=EmvsBM7o-5k

DFS + Trie

*/
class TrieNode{
    char c;
    int ends;
    TrieNode[] children = new TrieNode[26];
    String word;
    
    public TrieNode(char c, int ends, String word){
        this.c = c;
        this.ends = ends;
        this.word = word;
    }
}

class Solution {
    TrieNode root = new TrieNode('/', 0, "");
    ArrayList<String> output = new ArrayList<>();
    
    public void makeTrie(String word){
        TrieNode curr = root;
        int len = word.length();
        
        for(int i=0; i<len; i++){
            char c = word.charAt(i);
            
            int index = c - 'a';
            
            if(curr.children[index] != null){
                curr = curr.children[index];
            }else{
                curr.children[index] = new TrieNode(c, 0, curr.word+c);
                curr = curr.children[index];
            }
            
            if(i == len-1){
                curr.ends = curr.ends+1;
            }
        }
    }
    
    public void backtrack(char[][] board, int i, int j, int m, int n, TrieNode curr){
        int index = board[i][j] - 'a';
        if(board[i][j] == '$' || curr.children[index] == null){
            return;
        }else{
            curr = curr.children[index];
            if(curr.ends > 0){
                output.add(curr.word);
                curr.ends = curr.ends-1;
            }
            
            char ch = board[i][j];
            board[i][j] = '$'; //mark as visited
            
            if(i>0)
                backtrack(board, i-1, j, m, n, curr);
            if(j>0)
                backtrack(board, i, j-1, m, n, curr);
            if(i<m-1)
                backtrack(board, i+1, j, m, n, curr);
            if(j<n-1)
                backtrack(board, i, j+1, m, n, curr);
            
            board[i][j] = ch; //backtrack
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        for(String w : words){
            makeTrie(w);
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                backtrack(board, i, j, m , n, root);
            }
        }
        
        return output;
    }
}
