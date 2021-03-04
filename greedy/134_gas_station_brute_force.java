class Solution {
    
    public boolean isPossible(int[] gas, int[] cost, int start){
        int currIndex = start;
        int gasLeft = 0;
        
        do{
            gasLeft += gas[currIndex];
            
            if(cost[currIndex] <= gasLeft){
                gasLeft -= cost[currIndex];
                currIndex = (currIndex+1) % gas.length;
            }else{
                return false;
            }
        }while(currIndex != start);
        
        return true;
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int len = gas.length;
        
        for(int i=0; i<len; i++){
            if(gas[i] - cost[i] < 0) continue;
            int start = i;
            
            if(isPossible(gas, cost, start)) return start;
        }
        
        return -1;
    }
}
