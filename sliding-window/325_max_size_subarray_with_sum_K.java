class Solution {
    
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap(); //sum -> index
        
        hm.put(0, -1); //since we have to find earliest index with given sum, for 0 its before the array
        
        int sum = 0;//will have sum from index 0
        int maxLen = 0;
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            
            int find = sum-k; //if there is a sum-k, which occurred before, this means from THAT index till now, sum = k
            
            if(hm.containsKey(find)){
                maxLen = Math.max(maxLen, i - hm.get(find));
            }
            
            hm.putIfAbsent(sum, i); //"putIfAbsent" because we only want the earliest index
        }
        
        return maxLen;
    }
}
