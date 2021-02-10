/**
The basic idea is using DFS to check if the current node was already included in the traveling path. In this case, we need to convert graph presentation from edge list to adjacency list first, and then check if there's cycle existing in any subset. Because tree is a connected graph, we can start from any node.

The graph is possibly not connected, so need to check every node.

To do memorization and pruning, a HashMap is used to save the previous results for the specific node.
*/

class Solution {
    
    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    
    //had to store already computed hasCycle results, otherwise TLE
    HashMap<Integer, Boolean> hasCycleDp = new HashMap<>();
    
    public boolean hasCycle(int curr, HashSet<Integer> visited){
        if(visited.contains(curr)) return true;
        
        if(hasCycleDp.containsKey(curr)) return hasCycleDp.get(curr);
        
        if(adj.containsKey(curr)){
            visited.add(curr);
            
            for(int n : adj.get(curr)){
                if(visited.contains(n)) return true;
                boolean hasCycle = hasCycle(n, visited);
                hasCycleDp.put(curr, hasCycle);
                if(hasCycle) return true;
            }
            
            visited.remove(curr); //backtrack, beacause there can be multiple courses with same pre-requisite
        }
        
        return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] p : prerequisites){
            adj.computeIfAbsent(p[0], x -> new ArrayList()).add(p[1]);
        }
        
        for(int e : adj.keySet()){
            boolean hasCycle = hasCycle(e, new HashSet<>());
            if(hasCycle) return false;
        }
        
        return true;
    }
}
