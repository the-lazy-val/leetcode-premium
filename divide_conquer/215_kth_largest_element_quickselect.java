class Solution {
    
    public int partition(int[] ar, int start, int end){
        
        if(start==end) return start;
        
        Random rand = new Random(); //Randomization is important in quickselect, otherwise worst case is O(N^2)
        int pivotIndex = rand.nextInt(end-start) + start;
        int pivotElement = ar[pivotIndex];
        
        ar[pivotIndex] = ar[end];
        ar[end] = pivotElement;
        
        int i=start;
        int j=start;
        
        while(j < end){
            if(ar[j] < pivotElement){
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        
        int temp = ar[i];
        ar[i] = ar[end];
        ar[end] = temp;
        
        return i;
    }
    
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        
        int start=0;
        int end=n-1;
        
        int find = n-k; //find k-th largest = find (n-k)th smallest
        
        int pivot = -1;
        while(true){
            pivot = partition(nums, start, end);
            if(pivot == find){
                return nums[pivot];
            }else if(pivot < find){
                start = pivot+1;
            }else{
                end = pivot-1;
            }
        }
        
    }
}
