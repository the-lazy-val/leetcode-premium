/**
My solution: works but time limit exceeds on big inputs
First check cycle
then do topological sort
*/
class Solution {
    
    Stack<Integer> st;
    boolean[] visit;
    
    public boolean cycleUtil(ArrayList<Integer>[] adj, boolean[] visited, int node){
        boolean flag = false;
        visited[node] = true;
        
        for(int i : adj[node]){
            if(visited[i]){
                flag = true;
                break;
            }else{
                flag = cycleUtil(adj, visited, i);
            }
        }
        
        visited[node] = false; //backtrack
        return flag;
    }
    
    public boolean hasCycle(ArrayList<Integer>[] adj){
        for(int i=0; i<adj.length; i++){
            
            boolean[] visited = new boolean[adj.length];
            boolean detectCycle = cycleUtil(adj, visited, i);
            
            if(detectCycle) return true;
        }
        return false;
    }
    
    public void dfs(ArrayList<Integer>[] adj, boolean[] visit, int node, Stack<Integer> st){
        visit[node] = true;
        for(int i : adj[node]){
            if(!visit[i]) dfs(adj, visit, i, st);
        }
        st.push(node);
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        
        for(int i=0; i<adj.length; i++){
            adj[i] = new ArrayList<Integer>();
        }
        
        for(int[] e : prerequisites){
            adj[e[1]].add(e[0]);
        }
        
        
        if(hasCycle(adj)){
            return new int[0];
        }
        
        st = new Stack<>();
        visit = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++){
            if(!visit[i]){
                dfs(adj, visit, i, st);
            }
        }
        
            List<Integer> li = new ArrayList(st);
            Collections.reverse(li);
            int[] res = li.stream().mapToInt(Integer::intValue).toArray();
            return res;
        
    }
}

/**
Cycle detection as part of DFS

If element is already visited, but is not part of output stack, that means there is a cycle
https://www.youtube.com/watch?v=Akt3glAwyfY
*/

class Solution {
    
    Stack<Integer> st;
    boolean[] visit;
    boolean flag;
    
    public void dfs(ArrayList<Integer>[] adj, boolean[] visit, int node, Stack<Integer> st){
        visit[node] = true;
        for(int i : adj[node]){
            if(!visit[i]) {
                dfs(adj, visit, i, st);
            }else{
                if(!st.contains(i)){ //course is not added to output(stack) but is visited, so its a cycle
                    flag = true;
                    break;
                }
            }
        }
        st.push(node);
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        flag = false;
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        
        for(int i=0; i<adj.length; i++){
            adj[i] = new ArrayList<Integer>();
        }
        
        for(int[] e : prerequisites){
            adj[e[1]].add(e[0]);
        }
        
        
        st = new Stack<>();
        visit = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++){
            if(!visit[i]){
                dfs(adj, visit, i, st);
                if(flag){
                    break;
                }
            }
        }
        
        if(flag){
            return new int[0];
        }else{
            List<Integer> li = new ArrayList(st);
            Collections.reverse(li);
            int[] res = li.stream().mapToInt(Integer::intValue).toArray();
            return res;
        }
    }
}
