class Solution {
    
    public int count(int[] nums, int start, int end, int elem){
        int count=0;
        for(int i=start; i<=end; i++){
            if(nums[i] == elem) count++;
        }
        return count;
    }
    
    public int divideConquer(int[] nums, int start, int end){
        if(start==end) return nums[start];
        int mid = (start+end)/2;
        
        int leftMajority = divideConquer(nums, start, mid);
        int rightMajority = divideConquer(nums, mid+1, end);
        
        if(leftMajority==rightMajority) return leftMajority;
        
        int leftCount = count(nums, start, mid, leftMajority);
        int rightCount = count(nums, mid+1, end, rightMajority);
        
        if(leftCount>rightCount) return leftMajority; else return rightMajority;
        
    }
    
    public int majorityElement(int[] nums) {
        return divideConquer(nums, 0, nums.length-1);
    }
}
