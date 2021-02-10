class Solution {
    
    /**
    Recall that a graph, G, is a tree iff the following two conditions are met:

    - G is fully connected. In other words, for every pair of nodes in G, there is a path between them.
    - G contains no cycles. In other words, there is exactly one path between each pair of nodes in G.

Depth-first search is a classic graph-traversal algorithm that can be used to check for both of these conditions:

    - G is fully connected if, and only if, we started a depth-first search from a single source and discovered all nodes in G during it.
    - G contains no cycles if, and only if, the depth-first search never goes back to an already discovered node. We need to be careful though not to count trivial cycles of the form A → B → A that occur with most implementations of undirected edges.

    */
    
    public boolean hasCycle(HashMap<Integer, HashSet<Integer>> adj, int curr, HashSet<Integer> visited, int parent){ 
        // if(visited.contains(curr)) return true;
        
        visited.add(curr);
        
        if(adj.containsKey(curr)){
            for(int i : adj.get(curr)){
                if((visited.contains(i) && parent != i) || (!visited.contains(i) && hasCycle(adj, i, visited, curr))){
                    return true;
                }
            }
        }
        
//         visited.remove(curr);  every node should be covered in single DFS, if its a tree
        return false;
    }
    
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        
        for(int[] e : edges){
            adj.computeIfAbsent(e[0], x -> new HashSet()).add(e[1]);
            adj.computeIfAbsent(e[1], x -> new HashSet()).add(e[0]);
        }
        
        HashSet<Integer> visited = new HashSet();
        
        // for(int n : adj.keySet()){
        //     boolean hasCycle = hasCycle(adj, n, visited);
        //     if(hasCycle) return false;
        // }
        
        //Undirected Graph can only be Tree if all nodes get covered in single DFS / BFS
        boolean hasCycle = hasCycle(adj, 0, visited, -1);
        if(hasCycle) return false;

        
        for(int i=0; i<n; i++){
            if(! visited.contains(i)) return false; 
            //Undirected Graph can only be Tree if all nodes get covered in single DFS
        }
        
        return true;
    }
}
