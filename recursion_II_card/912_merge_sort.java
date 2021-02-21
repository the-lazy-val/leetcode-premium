class Solution {
    
    public void mergeSort(int[] nums, int low, int high){
        if(low>=high) return;
        
        int mid = low + (high-low)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        
        merge(nums, low, mid, high);
    }
    
    public void merge(int[] nums, int low, int mid, int high){
        if(low>=high) return;
        
        int p = low;
        int q = mid+1;
        
        int[] merged = new int[high-low+1];
        int index=0;
        
        while(p<=mid && q<=high){
            if(nums[p]<nums[q]){
                merged[index++] = nums[p++];
            }else{
                merged[index++] = nums[q++];
            }
        }
        
        while(p<=mid){
            merged[index++] = nums[p++];
        }
        
        while(q<=high){
            merged[index++] = nums[q++];
        }
        
        System.arraycopy(merged, 0, nums, low, high-low+1);
    }
    
    public int[] sortArray(int[] nums) {
        if(nums.length<=1) return nums;
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}
