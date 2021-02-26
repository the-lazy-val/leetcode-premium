class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int[] output = new int[nums.length];
        int k = nums.length-1;//to start filling output from the end with the bigger square number
        
        int i=0;
        int j=nums.length-1;
        
        while(i<=j){
            
            int leftSqr = nums[i] * nums[i];
            int rightSqr = nums[j] * nums[j];
            
            if(i==j){ //only 1 element left now
                output[k] = leftSqr;
                k--;
                i++;
            }else if(leftSqr > rightSqr){
                output[k] = leftSqr;
                k--;
                i++;
            }else{
                output[k] = rightSqr;
                k--;
                j--;
            }
            
        }
        
        return output;
    }
}
