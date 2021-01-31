/**
First approach: complete binary search
*/

class Solution {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    
    public void find(int[] nums, int low, int high, int target){
        if(low <= high){
            
        int mid = (low+high)/2;
        int midValue = nums[mid];
        
        if(midValue < target){
            find(nums, mid+1, high, target);
        }else if(midValue > target){
            find(nums, low, mid-1, target);
        }else{
            min = Math.min(min, mid);
            max = Math.max(max, mid);
            find(nums, low, mid-1, target);
            find(nums, mid+1, high, target);
        }
        }
    }
    
    public int[] searchRange(int[] nums, int target) {
        find(nums, 0, nums.length-1, target);
        if(min == Integer.MAX_VALUE){
            return new int[]{-1, -1};
        }else{
            return new int[]{min, max};
        }
    }
}

/**
second approach: binary search once, then iterate on both side
*/
