class Solution {
    
    public int helper(int N, int K){
        if(N==1 && K==1) return 0;
        
        if(K%2==0){
            int prev = helper(N-1, K/2);
            return (prev==0) ? 1 : 0;
        }else{
            return helper(N-1, (K+1)/2);
        }
    }
    
    public int kthGrammar(int N, int K) {
        
        return helper(N, K);
    }
}
