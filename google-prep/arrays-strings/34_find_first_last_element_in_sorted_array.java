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
class Solution {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    
    public int find(int[] nums, int low, int high, int target){
        if(low <= high){
            
        int mid = (low+high)/2;
        int midValue = nums[mid];
        
        if(midValue < target){
            return find(nums, mid+1, high, target);
        }else if(midValue > target){
            return find(nums, low, mid-1, target);
        }else{
            min = Math.min(min, mid);
            max = Math.max(max, mid);
            return mid;
        }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        
        int firstMid = find(nums, 0, nums.length-1, target);
        if(firstMid == -1){
            return ans;
        }
        
        //After finding the first position of target
        //iteratively update min & max value, towards left & right
        
        while(min > 0 && nums[min-1] == target){
            min--;
        }
        
        while(max < nums.length-1 && nums[max+1] == target){
            max++;
        }
        
        return new int[]{min, max};
    }
}
