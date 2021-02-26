class Solution {
    public int longestOnes(int[] A, int K) {
        int count1 = 0;
        
        int i=0;
        int j=0;
        int max = 0;
        
        while(j < A.length){
            int curr = A[j];
            
            if(curr==1) count1++;
            
            if(j-i+1 - count1 > K){
                
                int rem = A[i];
                if(rem == 1) count1--;
                i++;
            }
            
            max = Math.max(max, j-i+1);
            j++;
        }
        
        return max;
    }
}
