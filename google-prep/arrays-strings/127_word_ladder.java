/**
https://www.youtube.com/watch?v=ZVJ3asMoZ18

DFS Approach: using queue & set
218 ms
beats 28%
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


/**
Constructing graph using HashMap
 40 ms
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        for(String word : wordList) {
            buildGraph(word, graph);
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int res = 1;
        
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                String cur = queue.poll();
                for(int j = 0; j < cur.length(); j++) {
                    String key = cur.substring(0, j) + "*" + cur.substring(j+1, cur.length());
                    if(!graph.containsKey(key))     continue;
                    for(String neigh : graph.get(key)) {
                        if(visited.contains(neigh))     continue;
                        if(neigh.equals(endWord))   return res + 1;
                        visited.add(neigh);
                        queue.offer(neigh);
                    }
                }
            }
            res++;
        }
        
        return 0;
    }
    
    private void buildGraph(String word, Map<String, List<String>> graph) {
        for(int j = 0; j < word.length(); j++) {
            String key = word.substring(0, j) + "*" + word.substring(j+1, word.length());
            graph.putIfAbsent(key, new ArrayList<>());
            graph.get(key).add(word);
        }
    }
}
