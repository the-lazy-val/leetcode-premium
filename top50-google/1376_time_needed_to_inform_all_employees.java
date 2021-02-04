/**
My solution: 95 ms
beats 72 %

Using DFS and maintain max
*/

class Solution {
    
    HashMap<Integer, ArrayList<Integer>> hm = new HashMap();
    int max = 0;
    
    public void dfs(int currId, int currTime, int[] informTime){
        max = Math.max(max, currTime);
        if(hm.containsKey(currId)){
            for(int next : hm.get(currId)){
                dfs(next, currTime+informTime[next], informTime);
            }
        }
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        for(int i=0; i<manager.length; i++){
            if(manager[i]!=-1){
                hm.computeIfAbsent(manager[i], x -> new ArrayList()).add(i);
            }
        }
        
        dfs(headID, informTime[headID], informTime);
        return max;
    }
}
