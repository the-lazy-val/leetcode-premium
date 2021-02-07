class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int len = nums.length;
        
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        
        prefix[0] = 1;
        
        for(int i=1; i<len; i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        
        suffix[len-1] = 1;
        
        for(int i=len-2;  i>=0; i--){
            suffix[i] = suffix[i+1]*nums[i+1];
        }
        
        int[] output = new int[len];
        for(int i=0; i<len; i++){
            output[i] = prefix[i]*suffix[i];
        }
        
        /**
        For constant space, don't have suffix array, instead keep track of product from reverse in variable
        
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', R would contain the 
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        */
        
        return output;
    }
}
