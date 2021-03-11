public class Solution {
    
    int min = Integer.MAX_VALUE;
    
    Integer[][] dp;
    
    public int combinations(ArrayList<Integer> A, int len, int total, int start, int sumTillNow){
        if(start == len) return Math.abs(total - 2*sumTillNow);
        
        if(dp[start][sumTillNow] != null) return dp[start][sumTillNow];
        
        int localMin = Math.min(
            combinations(A, len, total, start+1, sumTillNow+A.get(start)),
            combinations(A, len, total, start+1, sumTillNow));
        
        min = Math.min(min, localMin);
        
        dp[start][sumTillNow] = localMin;
        return localMin;
    }
    
    public int solve(ArrayList<Integer> A) {
        int total = 0;
        for(int num : A){
            total += num;
        }
        
        int len = A.size();
        
        dp = new Integer[len][total+1];
        
        //dp[i][j] -> ith index tak jab j tk ka sum ho gya h, tab min kitna h
        
        combinations(A, len, total, 0, 0);
        
        return min;
    }
}
