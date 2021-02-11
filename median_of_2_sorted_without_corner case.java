class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == nums2.length && nums1.length ==0) {return 0.0;}
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        int half = (length1+length2)/2;
        
        int low = 0; 
        int high = length1-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            int left1 = nums1[mid];
            int right1 = nums1[mid+1];
            
            //important... if we select first 2 elements from one array & half of total lengths of both array is 6
            //then we need to select 6-2=4 elements from the second array for that partition
            int mid2 = half-mid;
            
            int left2 = nums2[mid2];            
            int right2 = nums2[mid2+1];
            
            if(left1<=right2 && left2<=right1){
                return getamongFour(left1, left2, right1, right2, length1+length2);
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
