/**
https://www.youtube.com/watch?v=ZVJ3asMoZ18

DFS Approach: using queue & set
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        
        for(String w : wordList){
            wordSet.add(w);
        }
        
        if(!wordSet.contains(endWord)){
            return 0;
        }
        
        Queue<String> q = new LinkedList<>();
        int depth = 0;
        q.add(beginWord);
        
        boolean notDone = true;
        
        while(!q.isEmpty() && notDone){
            depth+=1;
            int levelSize = q.size();
            while(levelSize > 0 && notDone){
                
                String curr = q.remove();
                levelSize--;
                String temp = curr;
                
                for(int i=0; i<curr.length();i++){
                    for(char c='a'; c<= 'z';c++){
                        // temp = curr.setCharAt(i, c);
                        
                        temp = curr.substring(0, i) + c + curr.substring(i + 1); 
                        if(temp.equals(curr)){
                            
                        }
                        else if(temp.equals(endWord)){
                            notDone = false;
                        }else if(wordSet.contains(temp)){
                            q.add(temp);
                            wordSet.remove(temp);
                        }
                    }
                }
                
                
            }
        }
        
        if(notDone){
            return 0;
        }else{
            return depth+1;
        }
    }
}
