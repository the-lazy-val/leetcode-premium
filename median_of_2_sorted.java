class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == nums2.length && nums1.length ==0) {return 0.0;}
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        int totalLength = length1+length2;
        
        int low = 0; 
        int high = length1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            //To handle edge cases
            int left1 = (mid == 0) ? Integer.MIN_VALUE : nums1[mid-1];
            int  right1 = (mid == length1) ? Integer.MAX_VALUE : nums1[mid];
            
            //important... if we select first 2 elements from one array & half of total lengths of both array is 6
            //then we need to select 6-2=4 elements from the second array for that partition
            int mid2 = (totalLength+1)/2 - mid;
            
            
            int left2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2-1];
            int right2 = (mid2 == length2) ? Integer.MAX_VALUE : nums2[mid2];
            
            
            if(left1<=right2 && left2<=right1){
                return getamongFour(left1, left2, right1, right2, totalLength);
            }else if(left1>right2){
                high=mid-1; //this means our max of left has extra member 
            }else{
                low=mid+1; //this means left has less member
            }
        }
       return 0.0; 
    }
    
    
    public double getamongFour(int left1,int left2, int right1, int right2, int length){
        if(length%2==0){
            return (double)(Math.max(left1,left2) + Math.min(right1,right2))/2;
        }
        return (double)Math.max(left1,left2);
    }
    
}
