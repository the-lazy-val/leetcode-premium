class Solution {
    
    class TrieNode{
        boolean isEnd;
        String str;
        TrieNode[] children;
        
        public TrieNode(){
            str="";
            children = new TrieNode[26];
        }
    }
    
    public void addWord(TrieNode root, String w){
        boolean flag=false;
        
        for(int i=0; i<w.length(); i++){
            char c = w.charAt(i);
            if(c>=65 && c<=90){
                if(root.children[c-'A']==null){
                    TrieNode temp = new TrieNode();
                    root.children[c-'A']=temp;
                }
                root=root.children[c-'A'];
                flag=true;
            }else{
                if(flag){
                    root.str+=c;
                }
            }
        }
        root.isEnd=true;
    }
    
    public boolean isValid(TrieNode root, String q){
        String temp="";
        
        for(int i=0; i<q.length(); i++){
            char c = q.charAt(i);
            if(c>=65 && c<=90){
                if(temp.length()!=0) return false;
                if(root.children[c-'A']==null) return false;
                root=root.children[c-'A'];
                temp=root.str;
            }else if(temp.length()!=0){
                if(temp.charAt(0) == c) temp=temp.substring(1);
            }
        }
        
        return root.isEnd && (temp.length()==0);
    }
    
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        
        TrieNode root = new TrieNode();
        TrieNode temp = root;
        addWord(temp, pattern);
        
        List<Boolean> res = new ArrayList();
        
        for(int i=0; i<queries.length; i++){
            temp=root;
            res.add(isValid(temp, queries[i]));
        }
        
        return res;
    }
}
