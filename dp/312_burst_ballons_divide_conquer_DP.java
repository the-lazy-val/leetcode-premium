class Solution {
    
    // https://www.youtube.com/watch?v=uG_MtaCJIrM
    
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        int[] padded = new int[n+2];
        padded[0] = 1;
        padded[n+1] = 1;
        
        for(int i=0; i<n; i++){
            padded[i+1] = nums[i];
        }
        
        int[][] dp = new int[n+2][n+2]; //max for window starting at "i" & ending at "j"
        
        for(int windowSize=1; windowSize<=n; windowSize++){ //sliding window size
            
            for(int left=1; left <= n-windowSize+1; left++){ //where the sliding window starts
                
                int right = left+windowSize-1; //where this window ends
                
                int max = 0; //max from the choices of which ballon to burst last in the window
                
                for(int i=left; i<=right; i++){ //choice of the ballon to be burst last
                    
                    int balloonValue = padded[left-1] * padded[i] * padded[right+1]; //value from JUST bursting ballon at 'i'
                    
                    int leftValue = dp[left][i-1]; //max from window before 'i'
                    int rightValue = dp[i+1][right]; //max from window after 'i'
                    
                    int windowValue = leftValue + balloonValue + rightValue; //value of this window, where 'i' was choice to burst last
                    
                    max = Math.max(max, windowValue);
                }
                
                dp[left][right] = max; //updating max for window starting at "left" & ending at "right"
                
            }
                
        }
        
        return dp[1][n];
    }
}
