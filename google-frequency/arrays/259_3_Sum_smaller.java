/**
Better solution: O(N^2)

Two-pointer

*/
class Solution {
    
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        if(len<3) return 0;
        
        if(len==3){
            if(nums[0]+nums[1]+nums[2] < target) return 1; else return 0;
        }
        
        int count=0;
        
        Arrays.sort(nums);
        
        for(int i=0; i<len-2; i++){
            int j=i+1;
            int k=len-1;
            
            while(j<k){
                if(nums[i]+nums[j]+nums[k] >= target){
                    k--; //since nums[k] is the largest in sorted array, we contract from end if sum >= target
                }else{
                    count+=(k-j); //so i & j were fixed, nums[k] is the biggest number such that sum is < target, since element b/w j & k are smaller than k, they will aslo satisfy the condition
                    
                    j++; //next j
                }
            }
        }
        
        return count;
    }
}

/**
My solution
O(N^3)
*/

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        if(len<3) return 0;
        
        if(len==3){
            if(nums[0]+nums[1]+nums[2] < target) return 1; else return 0;
        }
        
        int[][] twoSums = new int[len][len];
        
        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                twoSums[i][j] = nums[i]+nums[j];
            }
        }
        
        int count=0;
        
        for(int i=0; i<len; i++){
            int temp = i+1;
            
            while(temp<len){
                for(int j=temp+1; j<len; j++){
                    if(nums[i]+twoSums[temp][j] < target) count++;
                }
                temp++;
            }
            
        }
        
        return count;
    }
}
