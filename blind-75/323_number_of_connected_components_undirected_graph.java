class Solution {
    
    public void dfs(HashMap<Integer, HashSet<Integer>> adj, int curr, HashSet<Integer> visited){
        // if(visited.contains(curr)) return; 
        //this condition will never come, because we are handling it at line 11
        
        visited.add(curr);
        
        if(adj.containsKey(curr)){
            for(int n : adj.get(curr)){
                if(!visited.contains(n)) dfs(adj, n, visited);
            }
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        
        for(int[] e : edges){
            adj.computeIfAbsent(e[0], x -> new HashSet()).add(e[1]);
            adj.computeIfAbsent(e[1], x -> new HashSet()).add(e[0]);
        }
        
        HashSet<Integer> visited = new HashSet();
        
        int count=0;
        
        // for(int i : adj.keySet()){
        //we need to check all nodes & not just the ones in edges.. because there may be independent nodes as well
        for(int i=0; i<n; i++){
            if(! visited.contains(i)){
                count++;
                dfs(adj, i, visited);
            }
        }
        
        return count;
    }
}
