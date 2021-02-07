class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int[] dp = new int[arr.length]; //dp[i] signifies length of minimum window till i, with sum==target
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        int res = Integer.MAX_VALUE; //sum of two windows, initalized to MAX
        
        //slidong window
        int l=0; //left
        int sum=0; //current window sum
        
        for(int r=0; r<arr.length; r++){
            sum+=arr[r];
            
            while(sum>target && l<=r){ //contract the window from left if sum>target
                sum-=arr[l];
                l++;
            }
            
            if(sum==target){
                int len = r-l+1; //current window length
                
                int prevBest = (l==0) ? Integer.MAX_VALUE : dp[l-1]; //smallest window before l
                
                //if a previous window exists, then only we can update the sum of 2 windows
                if(prevBest!=Integer.MAX_VALUE){
                    res = Math.min(res, prevBest+len);
                }
                
                //for processing future windows:
                //if there was no window before, then current window itself is minimum
                //if length of current window is mininum till now, then propagate this
                //otherwise previous window might have been smaller, so propagate that
                if(r==0) dp[r] = len; else dp[r] = Math.min(len, dp[r-1]);
                
            }else{
                //if no window exists, then propogate dp[r-1] 
                //if there was a valid window before, then that length will get propogated
                //if there was no valid window before, then MAX_VALUE will get propagated
                
                if(r==0) dp[r] = Integer.MAX_VALUE; else dp[r] = dp[r-1];
            }
        }
        
        if(res==Integer.MAX_VALUE) return -1; else return res;
    }
}
