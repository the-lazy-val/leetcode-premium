class Solution {
    
    int max = -1;
    
    public int getSum(int[] nums, int n, HashSet<Integer> visited, int index){
        int low = index-1;
        while(visited.contains(low)){
            low--;
        }
        
        int high = index+1;
        while(visited.contains(high)){
            high++;
        }
        
        int lowValue = (low >= 0) ? nums[low] : 1;
        int highValue = (high < n) ? nums[high] : 1;
        
        return lowValue * nums[index] * highValue;
    }
    
    public void backtrack(int[] nums, int n, HashSet<Integer> visited, int sum){
        if(visited.size() == n){
            max = Math.max(max, sum);
            return;
        }
        
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                visited.add(i);
                
                backtrack(nums, n, visited, sum + getSum(nums, n, visited, i));
                
                visited.remove(i);
            }
        }
    }
    
    public int maxCoins(int[] nums) {
        backtrack(nums, nums.length, new HashSet(), 0);
        
        return max;
    }
}
