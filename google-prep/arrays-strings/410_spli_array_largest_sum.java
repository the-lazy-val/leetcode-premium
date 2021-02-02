class Solution {
    
    int[][] dp;
    
    public int getMinMax(int[] nums, int start, int end, int m){
        System.out.println("start: "+start+" , end: "+end+" ,m : "+m);
        if(m==0){
            return dp[start][end];
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i=start; i<end-m; i++){
            int self = dp[start][i+m];
            int after = getMinMax(nums, i+m+1, end, m-1);
            
            System.out.println("min: "+min+" , self: "+self+" , after: "+after);
            
            min = Math.min(min, Math.max(self, after));
        }
        return min;
    }
    
    public int splitArray(int[] nums, int m) {
        if(m==1){
            int temp = 0;
            for(int n : nums){
                temp+=n;
            }
            return temp;
        }
        int len = nums.length;
        if(m==len){
            int temp = Integer.MIN_VALUE;
            for(int n : nums){
                temp = Math.max(temp, n);
            }
            return temp;
        }
        dp = new int[len][len];
        
        int inc = 0;
        while(inc<len){
            for(int i=0; i <len-inc; i++){
                if(inc==0){
                    dp[i][i] = nums[i];
                }else{
                    dp[i][i+inc] = dp[i][i+inc-1] + dp[i+inc][i+inc];
                }
            }
            inc++;
        }
        
        return getMinMax(nums, 0, len-1, m-1);
        
    }
}
