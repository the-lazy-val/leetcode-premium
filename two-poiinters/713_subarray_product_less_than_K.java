class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if(k==0) return 0;
        
        int count=0;
        
        int i=0;
        int j=0;
        
        int product = 1;
        
        int lastZero = -1;//track last position of 0
        
        while(j < nums.length){
            int curr = nums[j];
            
            if(curr==0){
                lastZero = j;
                count+= j+1; //since all subarrays till j will now be 0
                i = j+1; //update start of sliding window
                product = 1; //reset product
            }else{
                product = product * curr;
            
                while(product >= k && i<j){
                    int rem = nums[i];
                    product = product/rem;
                    i++;
                }
            
                if(product < k){
                    count += (lastZero+1) + (j-i+1); //since we will account  all subarrays which end  at 0,  just before j
                }
            }
            
            j++;
        }
        
        return count;
    }
}
