class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int start = 0;
        int end = cardPoints.length-k-1;
        
        int total=0;
        for(int p : cardPoints){
            total+=p;
        }
        
        int windowSum = 0;
        for(int i=start; i<=end; i++){
            windowSum+=cardPoints[i];
        }
        
        int max = total - windowSum;
        
        while(end!=cardPoints.length-1){
            windowSum -= cardPoints[start];
            start++;
            end++;
            windowSum += cardPoints[end];
            
            max = Math.max(max, (total-windowSum));
        }
        
        return max;
    }
}
