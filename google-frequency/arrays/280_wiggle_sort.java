//nums[0] <= nums[1] >= nums[2] <= nums[3]...

class Solution {
    public void wiggleSort(int[] nums) {
        
        for(int i=0; i<nums.length-1; i++){
            int curr = nums[i];
            int next = nums[i+1];
            if(i%2==0){
                if(curr>next){
                    nums[i]=nums[i+1];
                    nums[i+1]=curr;
                }
            }else{
                if(curr<next){
                    nums[i]=nums[i+1];
                    nums[i+1]=curr;
                }
            }
        }
    }
}
