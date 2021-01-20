/**
My solution: 6 ms
Beats: 58.9 %
*/
class Solution {
    
    public void addEntry(List<String> res, int start, int end){
        if(start == end){
            res.add(Integer.toString(start));
        }else{
            res.add(Integer.toString(start)+"->"+Integer.toString(end));
        }
    }
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<>();
        
        int len = nums.length;
        
        if(len == 0){
            addEntry(res, lower, upper);
            return res;
        }
        
        if(nums[0] != lower){
            addEntry(res, lower, nums[0]-1);
        }
        
        if(len != 1){
            for(int i=1; i<len; i++){
                int diff = nums[i] - nums[i-1];
                
                if(diff != 1){
                    addEntry(res, nums[i-1]+1, nums[i]-1);
                }
            } 
        }
        
        if(nums[len-1] != upper){
                addEntry(res, nums[len-1]+1, upper);
        }
        
        return res;
    }
}
