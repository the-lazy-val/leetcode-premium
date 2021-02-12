class Solution {
    
    public int crossSum(int[] nums, int start, int end, int mid){
        
        if(start==end) return nums[start];
        
        int leftSubSum = Integer.MIN_VALUE;
        int currSum=0;
        for(int i=mid; i>=start; i--){
            currSum+=nums[i];
            leftSubSum=Math.max(leftSubSum, currSum);
        }
        
        int rightSubSum = Integer.MIN_VALUE;
        currSum=0;
        for(int i=mid+1; i<=end; i++){  //start from mid+1
            currSum+=nums[i];
            rightSubSum=Math.max(rightSubSum, currSum);
        }
        
        return leftSubSum + rightSubSum;
    }
    
    public int getMax(int[] nums, int start, int end){
        if(start==end) return nums[start];
        
        int mid = (start+end)/2;
        
        int leftSum = getMax(nums, start, mid); //max to left of mid
        int rightSum = getMax(nums, mid+1, end); //max to right of mid
        int crossSum = crossSum(nums, start, end, mid); //max crossing mid
        
        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }
    
    public int maxSubArray(int[] nums) {
        return getMax(nums, 0, nums.length-1);
    }
    
//     public int maxSubArray(int[] nums) {
//         int sum=0;
//         for(int n : nums){
//             sum += n;
//             if(n > sum){
//                 sum=n;
//             }
//             max = Math.max(max, sum);
//         }
        
//         return max;
//     }
}
