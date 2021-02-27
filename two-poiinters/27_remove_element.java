class Solution {
    public int removeElement(int[] nums, int val) {
        
        if(nums.length==0) return 0;
        
        int i = 0;
        int j = nums.length-1;
        
        while(j>=0 && nums[j] == val){
            j--;
        }
        
        if(j==-1) return 0;
        
        while(i<=j){
            if(nums[i]!=val){
                i++;
            }else{
                while(j>i && nums[j] == val){
                    j--;
                }
                
                if(j>i){
                    nums[i] = nums[j];
                    i++;
                    j--;
                }else{
                    break;
                }
            }
        }
        
        return i;
    }
}
