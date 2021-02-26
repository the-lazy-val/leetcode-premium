class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        if(nums1.length == 0)
            return nums1;
        if(nums2.length == 0)
            return nums2;
        
        HashSet<Integer> set1 = new HashSet();
        
        for(int n : nums1){
            set1.add(n);
        }
        
        int k = 0;
        
        for(int n : nums2){
            if(set1.contains(n)){
                nums1[k] = n;
                k++;
                set1.remove(n);
            }
        }
        
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
