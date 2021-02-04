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


/**
DFS + memoization

need to understand

https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/589738/Java-DFS-%2B-Memoization-(w-Explanation-and-Complexity-Analysis)

*/
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dfs(i, manager, informTime));
        }
        return max;
    }
    
    private int dfs(int id, int[] manager, int[] informTime) {
        if (manager[id] != -1) {
            informTime[id] += dfs(manager[id], manager, informTime);
            manager[id] = -1;
        }
        return informTime[id];
    }
}
